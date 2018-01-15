/**
 * Created by Administrator on 2017/12/1.
 */
var vm = new Vue({
    el:'#rrapp',
    data:{
        username: '',
        password: '',
        captcha: '',
        error: false,
        errorMsg: '',
        src: 'captcha.jpg'
    },
    beforeCreate: function(){
        if(self != top){
            top.location.href = self.location.href;
        }
    },
    methods: {
        refreshCode: function(){
            this.src = "captcha.jpg?t=" + $.now();
        },
        login: function () {
            var data = "username="+vm.username+"&password="+vm.password+"&captcha="+vm.captcha;
            $.ajax({
                type: "POST",
                url: baseURL + "sys/login",
                data: data,
                dataType: "json",
                success: function(r){
                    if(r.code == 0){//登录成功
                        localStorage.setItem("token", r.token);
                        parent.location.href ='index.html';
                    }else{
                        vm.error = true;
                        vm.errorMsg = r.msg;
                    }
                }
            });
        }
    }
});
//背景的动画部分
var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');
canvas.width = $(document).width();
canvas.height =$(document).height();
//如果浏览器支持requestAnimFrame则使用requestAnimFrame否则使用setTimeout
window.requestAnimFrame = (function() {
    return window.requestAnimationFrame ||
        window.webkitRequestAnimationFrame ||
        window.mozRequestAnimationFrame ||
        function(callback) {
            window.setTimeout(callback, 3000 / 60);
        };
})();
//初始角度为0
var step = 0;
//定义三条不同波浪的颜色
var lines = ["rgba(255,255,255, 0.2)","rgba(255,255,255, 0.4)", "rgba(255,255,255, 0.6)", "rgba(255,255,255, 0.8)", "rgba(255,255,255, 1)","rgba(255,255,255, 0.8)","rgba(255,255,255, 0.6)", "rgba(255,255,255, 0.4)", "rgba(255,255,255, 0.2)"];

function loop() {
    //清空canvas
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    //角度增加一度
    step += 1;
    //画3个不同颜色的矩形
    for(var j = lines.length - 1; j >= 0; j--) {
        ctx.fillStyle = lines[j];
        //每个矩形的角度都不同，每个之间相差45度
        //角度转换成弧度
        var angle;
        var deltaHeight;
        var deltaHeightRight;
        angle = (step + j*15) * Math.PI / 180;
        //矩形高度的变化量
        deltaHeight = Math.sin(angle) * 90;
        //矩形高度的变化量(右上顶点)
        deltaHeightRight = Math.cos(angle) * 90;
        //开启绘制
        ctx.beginPath();
        ctx.moveTo(0, canvas.height / 2 + deltaHeight);
        ctx.bezierCurveTo(canvas.width / 2, canvas.height / 2 + deltaHeight - 50, canvas.width / 2, canvas.height / 2 + deltaHeightRight - 50, canvas.width, canvas.height / 2 + deltaHeightRight);
        ctx.lineTo(canvas.width, canvas.height);
        ctx.lineTo(0, canvas.height);
        ctx.lineTo(0, canvas.height / 2 + deltaHeight);
        ctx.closePath();
        ctx.fill();
    }
    requestAnimFrame(loop);
}
loop();
//窗口自适应
var mainHeight;
function layout(){
    mainHeight=(parseInt($(window).height()) - 466)/2;
    $(".login-form").css("top", mainHeight+"px");
}
layout();
$(window).resize(function(){layout()});