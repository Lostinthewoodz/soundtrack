package com.example.soundtrack.config;

import com.example.soundtrack.controller.EntryResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        System.out.println("Registering resources");
        register(EntryResource.class);
    }
}
