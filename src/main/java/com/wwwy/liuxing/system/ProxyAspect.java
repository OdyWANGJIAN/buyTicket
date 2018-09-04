package com.wwwy.liuxing.system;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 *自定义切面类，在每个方法前后加入日志，以及异常日志
 * @author W1665
 * @date 2018/4/11
 */
@Component
@Aspect
public class ProxyAspect {

    private static final Logger logger = Logger.getLogger(ProxyAspect.class);

    @Before("execution(* com.wwwy..*.*(..))")
    public void buyBefore(){

        logger.debug(SysConfig.BeforeConfig.BEGINMETHOD);
    }

    @After("execution(* com.wwwy..*.*(..))")
    public void buyAfter(){

        logger.debug(SysConfig.BeforeConfig.ENDINGMETHOD);
    }
    @AfterThrowing(value = "execution(* com.wwwy..*.*(..))",
            throwing = SysConfig.BeforeConfig.WHILEEXCEPTION)
    public void throwEx(Exception ex){
        System.out.println(SysConfig.BeforeConfig.BEGINEXCEPTION+ex.getMessage());
    }
}
