package com.broada.springboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoRTLogAspect {

    private static final Logger logger = LoggerFactory.getLogger("daoRTLog");

    @Pointcut("execution(public * com.broada.one.data.repo..*.*(..))")
    public void daoLog() {
    }

    @Around("daoLog()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().toString();
        Long _startTime = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } finally {
            Long _wasteTime = System.currentTimeMillis() - _startTime;
            if (_wasteTime > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("method=").append(method).append(",wasteTime=").append(_wasteTime);
                logger.info(sb.toString());
            }
        }
    }

}
