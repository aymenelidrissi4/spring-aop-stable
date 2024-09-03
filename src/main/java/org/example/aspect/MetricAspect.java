package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MetricAspect {

    private final Map<String, Integer> metricCounts = new ConcurrentHashMap<>();

    public Object countMetric(ProceedingJoinPoint joinPoint) throws Throwable {
        metricCounts.merge(joinPoint.getSignature().getName(), 1, Integer::sum);
        try {
            return joinPoint.proceed();
        } finally {
            System.out.println("Metric [" + joinPoint.getSignature().getName() + "] count: " + metricCounts.get(joinPoint.getSignature().getName()));
        }
    }
}
