package com.example.provider.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.provider.api.UserService;
import com.example.provider.dao.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String getUserInfo(Long id) {
        ArrayList<Object> list = new ArrayList<>();
        int i  = 0;
        while (i < id){
            list.add(new String());
        }
        return JSON.toJSONString(userinfoMapper.selectByPrimaryKey(id));
    }

    public void insertUserInfo() {
        jdbcTemplate.update("insert into users values(null,?,?)","dd",25);
    }

}
