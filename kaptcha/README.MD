#验证码模块
##配置验证吗
********
###注入即可使用Producer
> @Autowired
  	public KaptchaController(Producer producer) {
  		this.producer = producer;
  	}