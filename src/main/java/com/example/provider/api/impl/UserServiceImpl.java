package com.example.provider.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.provider.api.UserService;
import com.example.provider.dao.UserinfoMapper;
import com.example.provider.dbmanager.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import static com.example.provider.dbmanager.DataSource.SOURCE_A;
import static com.example.provider.dbmanager.DataSource.SOURCE_B;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserinfoMapper userinfoMapper;

    public static AtomicLong increase = new AtomicLong(0);

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public void label(RedisTemplate<String,String> redisTemplate){
        if(redisTemplate.opsForValue().get("num") != null){
            increase = new AtomicLong(Integer.valueOf(redisTemplate.opsForValue().get("num")));
        }
    }

    @Override
    @DataSource(SOURCE_A)
    public String getUserInfo(Long id) {
        return JSON.toJSONString(userinfoMapper.selectByPrimaryKey(id));
    }

    @Override
    @DataSource(SOURCE_B)
    public String getUserInfo2(Long id) {
        return JSON.toJSONString(userinfoMapper.selectByPrimaryKey(id));
    }

}
