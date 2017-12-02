package com.example.springboot2.redis;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SlowService {

    public String execute(String arg){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        return UUID.randomUUID().toString();
    }
}
