package com.aed.cms.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author liudongxu06
 * @date 2018/6/19
 */
@Configuration
public class MongoPropertiesConfig {

    @Primary
    @Bean(name = "basicMongoProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.basic")
    public MongoProperties basicMongoProperties() {
        return new MongoProperties();
    }
}
