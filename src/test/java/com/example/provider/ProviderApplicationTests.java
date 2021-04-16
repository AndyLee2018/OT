package com.example.provider;

import com.example.provider.dao.UserinfoMapper;
import com.example.provider.model.Userinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class ProviderApplicationTests {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Test
    void contextLoads() {
        redisTemplate.opsForValue().set("hello","hello");
    }

}
