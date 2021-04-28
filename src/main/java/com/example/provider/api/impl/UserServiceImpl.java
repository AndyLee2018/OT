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
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public static final Integer num = 0;

    public static AtomicLong increase = new AtomicLong(0);

    @Override
    public String getUserInfo(Long id) {
        String num1 = redisTemplate.opsForValue().get("num");
        if(num1 == null){
            redisTemplate.opsForValue().set("num",num+"");
        }else{
            redisTemplate.opsForValue().set("num",Integer.valueOf(num1)+1+"");
        }
        ArrayList<Object> list = new ArrayList<>();
        int i  = 0;
        while (i < Integer.valueOf(num1)){
            list.add(new String());
            i++;
        }
        System.out.println(num1);
        return JSON.toJSONString(num1);
    }

    public void insertUserInfo() {
        jdbcTemplate.update("insert into users values(null,?,?)","dd",25);
    }

}
