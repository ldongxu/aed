package com.aed.cms.config;

import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * @author liudongxu06
 * @date 2018/6/19
 */
@Configuration
public class BasicMongoTemplate {
    @Autowired
    @Qualifier("basicMongoProperties")
    private MongoProperties mongoProperties;

    @Primary
    @Bean
    public MongoDbFactory basicFactory(MongoProperties mongoProperties){
        return new SimpleMongoDbFactory(new MongoClientURI(mongoProperties.getUri()));
    }

    @Primary
    @Bean(name = "basicMongo")
    public MongoTemplate basicMongoTemplate(){
        return new MongoTemplate(basicFactory(this.mongoProperties));
    }
}
