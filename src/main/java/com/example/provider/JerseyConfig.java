package com.example.provider;

import com.example.provider.rest.UserRest;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(UserRest.class);
    }
}
