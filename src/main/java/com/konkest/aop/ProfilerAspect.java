package com.konkest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ProfilerAspect {

	@Pointcut("execution(* com.konkest.*.*(..))")
	public void profiledMethods() {
	}

	@Around("profiledMethods()")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("BEGIN method : " + pjp.getTarget().getClass() + "."
				+ pjp.getSignature().getName());
		long start = System.nanoTime();
		Object output = pjp.proceed();
		long elapsedTime = System.nanoTime() - start;
		System.out.println("END Method - Execution time: " + elapsedTime
				+ " nanoseconds.");
		return output;
	}

	// AFAIK Spring AOP doesn't provide support for jointpoints other than
	// @Around
	// @Before("profiledMethods()")
	// public void entering(ProceedingJoinPoint pjp) throws Throwable {
	// System.out.println("BEGIN method : " + pjp.getTarget().getClass() + "." +
	// pjp.getSignature().getName());
	// }
	//
	// @After("profiledMethods()")
	// public void exiting(ProceedingJoinPoint pjp) throws Throwable {
	// System.out.println("END Method" + pjp.getTarget().getClass() + "." +
	// pjp.getSignature().getName());
	// }

}