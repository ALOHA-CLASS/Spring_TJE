package com.aloha.spring.common.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceLogAdvice {

	private static final Logger logger = LoggerFactory.getLogger(ServiceLogAdvice.class);

//	@Before("execution(* com.aloha.spring.service.*.*(..))")
//	@Before("execution(* *.*(..))")
	@Before("execution(* com.aloha.spring.service.BoardService*.*(..))")
	public void startLog(JoinPoint jp) {
		logger.info("startLog");
		logger.info("startLog : " + jp.getSignature());
		logger.info("startLog : " + Arrays.toString(jp.getArgs()));
	}
	
}
