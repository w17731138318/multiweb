package com.pasq.common.aspect;//package com.pasq.common.aspect;
//
//import com.pasq.common.exception.RRException;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Redis切面处理类
// *
// * @author wwx
// * @email wangweixin@pasq.com
// * @date 2017年11月29日
// */
//@Aspect
//@Configuration
//public class RedisAspect {
//    private Logger logger = LoggerFactory.getLogger(getClass());
//    //是否开启redis缓存  true开启   false关闭
//    @Value("${spring.redis.open}")
//    private boolean open;
//
//    @Around("execution(* com.pasq.common.utils.RedisUtils.*(..))")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        Object result = null;
//        if(open){
//            try{
//                result = point.proceed();
//            }catch (Exception e){
//                logger.error("redis error", e);
//                throw new RRException("Redis服务异常");
//            }
//        }
//        return result;
//    }
//}
