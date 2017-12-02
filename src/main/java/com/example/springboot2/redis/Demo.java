package com.example.springboot2.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Demo implements CommandLineRunner {
    private static Log logger = LogFactory.getLog(Demo.class);
    private final StringRedisTemplate template;
    private final SlowService service;

    @Autowired
    public Demo(StringRedisTemplate template, SlowService service) {
        this.template = template;
        this.service = service;
    }

    @Override
    public void run(String... strings) throws Exception {
        reset();
        caching();
    }

    private void reset(){
        this.template.delete(Arrays.asList("abc", "boot", "slow~keys", "data"));
    }

    private void caching(){
        logger.info("---> 1 " + this.service.execute("boot"));
        logger.info("---> 2 " + this.service.execute("boot"));
        logger.info("---> 3 " + this.service.execute("boot"));
    }
}
