package com.example.provider.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.provider.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Component
public class UserRest {

    @Autowired
    UserService userService;

    @Path("test")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String test(String param){
        JSONObject info = JSON.parseObject(param);
        return userService.getUserInfo(info.getLong("id"));
    }

    @Path("test2")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String test2(String param){
        JSONObject info = JSON.parseObject(param);
        return userService.getUserInfo2(info.getLong("id"));
    }
}
