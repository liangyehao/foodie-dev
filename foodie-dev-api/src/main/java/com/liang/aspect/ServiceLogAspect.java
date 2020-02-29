package com.liang.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/29 18:38
 * @content 业务层监控切面
 */

@Slf4j
@Component
@Aspect
public class ServiceLogAspect {

    /**
     *      表达式：impl..*.*(..)
     *      impl..  impl包及子包
     *      *       所有类
     *      *       所有方法
     *      (..)    任意参数
     *
     * 监控service方法执行时间
     * @param joinPoint joinPoint
     * @return 执行结果
     */
    @Around("execution(* com.liang.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("========= 开始执行 {}.{}({}) ==========",
                joinPoint.getTarget(),
                joinPoint.getSignature().getName(),
                joinPoint.getArgs());

        // 记录开始时间
        long beginTime = System.currentTimeMillis();

        // 方法执行
        Object result = joinPoint.proceed();

        // 记录结束时间
        long endTime = System.currentTimeMillis();

        // 计算执行花费时间
        long takeTime = endTime-beginTime;

        // 日志输出执行耗时结果
        if (takeTime>3000) {
            log.error("======== 执行结束，耗时：{} 毫秒 ========",takeTime);
        }else if(takeTime>2500){
            log.warn("======== 执行结束，耗时：{} 毫秒 ========",takeTime);
        }else{
            log.info("======== 执行结束，耗时：{} 毫秒 ========",takeTime);
        }

        return result;
    }

}
