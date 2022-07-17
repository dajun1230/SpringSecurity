package com.ycj.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootRedisTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {

        redisTemplate.opsForValue().set("name", "ycj");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }
}
