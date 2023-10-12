package com.joeun.test.common.aop;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@EnableAspectJAutoProxy
@Component
@Aspect
public class ServiceLogAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceLogAdvice.class);
	
	
	/**
	 * 어드 바이스 유형
	 * - Around
	 * - Before
	 * - After
	 * - AfterReturning
	 * - AfterThrowing
	 */
	
	/**
	 * 포인트컷 표현요소
	 * - 지시자 : execution
	 * - 반환값  
	 * - 패키지
	 * - 클래스
	 * - 메소드
	 * - 인수
	 */
	@Before("execution(* com.joeun.test.service.BoardService*.*(..))")
	public void startLog(JoinPoint jp) {
		// jp.getSignature() 	: 타겟 메소드의 시그처 정보(반환타입 패키지.클래스.메소드) 반환
		// jp.getArgs() 		: 타겟 메소드의 매개변수를 반환
		logger.info("===========================================");
		logger.info("Service - @Before");
		logger.info("startLog : " + jp.getSignature());
		logger.info("startLog : " + Arrays.toString(jp.getArgs()) );
		logger.info(jp.getTarget().toString());
		
		
	}
	
	
	@After("execution(* com.joeun.test.service.BoardService*.*(..))")
	public void endLog(JoinPoint jp) {
		logger.info("===========================================");
		logger.info("Service - @After");
		logger.info("endLog : " + jp.getSignature());
		logger.info("endLog : " + Arrays.toString(jp.getArgs()) );
		logger.info(jp.getTarget().toString());
	}
	
	/*
	 * @Around 유형을 적용하면, @After 어드바이스는 실행되지 않는다.
	 * 
	 * ProceedingJoinPoint : 어드바이스에서 대상 메서드의 실행을 제어하고 호출하는 객체
	 * - proceed() 			: 대상 메소드 호출
	 */
	@Around("execution(* com.joeun.test.service.BoardService*.*(..))")
	public void aroundLog(ProceedingJoinPoint jp) {
		logger.info("===========================================");
		logger.info("Service - @Around");
		LocalDateTime time = LocalDateTime.now();
		logger.info("현재 시간 : " + time);
		
		try {
			Object result = jp.proceed();
		} catch (Throwable e) {
			logger.error("예외가 발생했습니다.");
			e.printStackTrace();
		}
		
		// After, Around 를 함께 사용하려면, Around 어드바이스  에서 After 어드바이스를 호출해준다.
		endLog(jp);
	}
	
	
	// pointcut 	: 포인트컷 표현식
	// returning 	: 타겟 메소드의 반환값을 저장하는 매개변수명 지정
	@AfterReturning(pointcut = "execution(* com.joeun.test.service.BoardService*.*(..))", returning = "test")
	public void afterReturnLog(JoinPoint jp, Object test) {
		logger.info("===========================================");
		logger.info("Service - @AfterReturning");
		if( test != null )
			logger.info("Result : " + test.toString());
	}
	
	
	@AfterThrowing(pointcut = "execution(* com.joeun.test.service.BoardService*.*(..))", throwing ="exception")
	public void afterThrowingLog(JoinPoint jp, Exception exception) {
		logger.info("===========================================");
		logger.info("Service - @AfterThrowing");
		logger.info( exception.toString() ); 
	}
	
	

}
















