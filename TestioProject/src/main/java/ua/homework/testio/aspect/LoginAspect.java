package ua.homework.testio.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAspect {

    @Before(value = "publicMethodsPointCut()")
    public void loggingPublicMethodsAdvice(){
        System.out.println("public method was called");
    }

    @Pointcut(value = "execution(public * ua.homework.testio.service..*(..))")
    public void publicMethodsPointCut(){
    }

    @Around(value = "publicMethodsPointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.printf("before method %s\n", proceedingJoinPoint.getSignature().getName());
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.printf("after method %s\n", proceedingJoinPoint.getSignature().getName());

        return value;
    }

}
