package com.spring.i.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class TrackOperation {
	
    @Pointcut("execution(* Operation.*(..))")  
    public void setCounter(){}//pointcut name  
      
    @After("setCounter()")//applying pointcut on after advice  
    public void myadvice(JoinPoint jp)//it is advice (after advice)  
    {  
        System.out.println("additional concern");  
        //System.out.println("Method Signature: "  + jp.getSignature());  
    }  
	
}
