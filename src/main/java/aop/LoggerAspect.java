package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Component
@Aspect
public class LoggerAspect {
    private Logger _logger = Logger.getLogger(LoggerAspect.class.getName());

    @Before("aop.Pointcuts.allMethodsWithAnyParams()")
    public void beforeAllMethods(JoinPoint joinPoint) {
        _logger.info("beforeAllMethods advice is worked for " + joinPoint.getSignature());
    }

    @Before("aop.Pointcuts.onlyDogSayMethod()")
    public void beforeDogSayMethod(JoinPoint joinPoint) {
        _logger.info("beforeDogSayMethod advice is worked for " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "aop.Pointcuts.onlyTalkWithOtherMethod()", returning = "message")
    public void afterReturningTalkWithOtherMethod(JoinPoint joinPoint, String message) {
        _logger.info("afterReturningTalkWithOtherMethod advice is worked for " + joinPoint.getSignature());
        String stringArgs = "";
        Object[] args = joinPoint.getArgs();

        for(var elt : args) {
            stringArgs += (elt.toString() + ", ");
        }

        _logger.info("Args is " + stringArgs);
        _logger.info("Message is " + message);
    }

    @AfterThrowing(pointcut = "aop.Pointcuts.allExceptionMethodsWithAnyArguments()", throwing = "throwable")
    public void afterThrowingExceptionMethod(JoinPoint joinPoint, Throwable throwable) {
        _logger.info("afterThrowingExceptionMethod advice is worked for " + joinPoint.getSignature());
        _logger.info("Exception is: " + throwable);
    }
}
