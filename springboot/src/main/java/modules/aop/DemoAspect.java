package modules.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 熟知宇某
 * @date 2021/7/28 16:26
 */
@Component
@Aspect
public class DemoAspect {

    @Pointcut("@annotation(modules.annotation.DemoAnnotation)")
    public void executeScript(){

    }


    @Before("executeScript()")
    public void doBefore(){
        System.out.println("before.........");
    }

    @After("executeScript()")
    public void doAfter(){
        System.out.println("after.........");

    }

    @Around("executeScript()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("doAround11.........");
        Object ob = point.proceed();
        System.out.println("doAround22.........");
        return ob;
    }

}
