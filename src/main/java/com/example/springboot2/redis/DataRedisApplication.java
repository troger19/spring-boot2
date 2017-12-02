package com.example.springboot2.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Spring Boot application for Redis example
 */

@SpringBootApplication
@EnableCaching
public class DataRedisApplication {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DataRedisApplication.class, args);
    }

    @Bean
    RedisCacheManager cacheManager(StringRedisTemplate template) {
        return new RedisCacheManager(template);
    }
//
//    @Bean
//    RedisConnectionFactory connectionFactory() {
//        return new JedisConnectionFactory();
//    }



//    @Bean
//    StringRedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
//
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(connectionFactory);
//
//        return template;
//    }



//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
//
//        // Defaults
//        redisConnectionFactory.setHostName("127.0.0.1");
//        redisConnectionFactory.setPort(6379);
//        return redisConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
//        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//        redisTemplate.setConnectionFactory(cf);
//        return redisTemplate;
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//
//        // Number of seconds before expiration. Defaults to unlimited (0)
//        cacheManager.setDefaultExpiration(300);
//        return cacheManager;
//    }
}
