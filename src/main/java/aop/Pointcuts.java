package aop;


import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
    //Mask for PointCut (
    // access_modifier + return_type(required) + classpath
    // + method_name(required) + params(required) + throwing)
   @Pointcut("execution(public * model.*.*())")
    public void allPublicMethodsWithoutParams() {}

    @Pointcut("execution(void model.*.*(..))")
    public void allMethodsWithAnyParams() {}

    @Pointcut("execution(public void model.Dog.say())")
    public void onlyDogSayMethod() {}

    @Pointcut("execution(String *Other(String, model.Person))")
    public void onlyTalkWithOtherMethod() {}

    @Pointcut("execution(String *Exception(..))")
    public void allExceptionMethodsWithAnyArguments() {}
}
