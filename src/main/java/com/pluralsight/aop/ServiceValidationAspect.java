package com.pluralsight.aop;


import com.pluralsight.validation.ObjectName;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

@Component
@Aspect
public class ServiceValidationAspect {

    @Resource(name = "mvcValidator")
    private ValidatorFactory validatorFactory;

    @Around("execution(* com.pluralsight.service..*.*(..))")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        Validator validator = validatorFactory.getValidator();
        ExecutableValidator executableValidator = validator.forExecutables();
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();

        Set<ConstraintViolation<Object>> errors = executableValidator.validateParameters(joinPoint.getTarget(), method, joinPoint.getArgs());
        if(errors.size() > 0)
            throw new ConstraintViolationException(errors);

        Object returnValue = joinPoint.proceed();
        errors = executableValidator.validateReturnValue(joinPoint.getTarget(),method, returnValue);
        if(errors.size() > 0)
            throw new ConstraintViolationException(errors);

        return returnValue;

    }
}
