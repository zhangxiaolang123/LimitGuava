package com.zxl.config;

import com.google.common.util.concurrent.RateLimiter;
import com.zxl.enumd.ResponseEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component("rateLimitInterceptor")
public class RateLimitInterceptor extends AbstractInterceptor {
    private Logger logger = LoggerFactory.getLogger(RateLimitInterceptor.class);

    /**
     * 单机全局限流器(限制QPS为250)
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(1);//设置为1便于测试

    public static void setRate(double limiterQPS){
        rateLimiter.setRate(limiterQPS);
    }
    @Override
    protected ResponseEnum preFilter(HttpServletRequest request) {
        if (!rateLimiter.tryAcquire()) {
            logger.warn("限流中......");
            return ResponseEnum.RATE_LIMIT;
        }
        return ResponseEnum.SUCCESS;
    }
}