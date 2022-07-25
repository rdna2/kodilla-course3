package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FacadeWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(FacadeWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)")
    public void logEvent(OrderDto order, long userId, Object object) {
        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + order + ", UserId: " + userId);
    }

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public void logEvent() {
        LOGGER.info("\nLogging the event: OrderFacade processOrder method call");
    }


    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object OrderStatus(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
            LOGGER.info("SYSTEM INFO: ORDER SUCCEEDED!");
        } catch (Throwable throwable) {
            LOGGER.error("SYSTEM INFO: ORDER FAILED: " + throwable.getMessage());
            throw throwable;
        }
        return result;
    }

}