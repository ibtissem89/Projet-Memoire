package com.BackendE.backendProject.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.sql.Blob;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules(); // Registers standard Jackson modules
        objectMapper.registerModule(new SimpleModule().addDeserializer(Blob.class, new BlobDeserializer()));
        return objectMapper;
    }
}

