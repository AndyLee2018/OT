package com.example.provider.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.provider.api.UserService;
import com.example.provider.dao.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserinfoMapper userinfoMapper;

    public static Integer num = 0;

    public static AtomicLong increase = new AtomicLong(0);

    @Autowired
    public void label(RedisTemplate<String,String> redisTemplate){
        if(redisTemplate.opsForValue().get("num") != null){
            increase = new AtomicLong(Integer.valueOf(redisTemplate.opsForValue().get("num")));
        }
    }

    @Override
    public String getUserInfo(Long id) {
        ArrayList<Object> list = new ArrayList<>();
        int i  = 0;
        while (i < increase.intValue()){
            list.add(new String());
            i++;
        }
        System.out.println(increase);
        return JSON.toJSONString(increase);
    }

    public void insertUserInfo() {
        jdbcTemplate.update("insert into users values(null,?,?)","dd",25);
    }

}
