package com.lettuce.lettuce;

import io.lettuce.core.ClientOptions;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName:LettuceAutoConfiguration
 * @Describe:
 * @Data:2020/6/1010:44
 * @Author:Ago
 * @Version 1.0
 */
@Configuration
@ConditionalOnClass(name = "io.lettuce.core.RedisURI")
@EnableConfigurationProperties(LettuceProperties.class)
@RequiredArgsConstructor
public class LettuceAutoConfiguration {

    private final LettuceProperties lettuceProperties;

    @Bean(destroyMethod = "shutdown")
    public ClientResources clientResources(){

        return DefaultClientResources.create();
    }

    @Bean
    @ConditionalOnProperty("lettuce.single.host")
    public RedisURI singleRedisUri(){
        LettuceSingleProperties single = lettuceProperties.getSingle();
        RedisURI redisRri = RedisURI.builder().withHost(single.getHost()).withPort(single.getPort()).withDatabase(single.getDataBase()).build();
        return redisRri;
    }

    @Bean(destroyMethod = "shutdown")
    @ConditionalOnProperty("lettuce.single.host")
    public RedisClient singleRedisClient(ClientResources clientResources, @Qualifier("singleRedisUri") RedisURI redisUri){
        return RedisClient.create(clientResources, redisUri);
    }

    @Bean
    @ConditionalOnProperty("lettuce.single.host")
    public StatefulRedisConnection<String,String> statefulRedisConnection(@Qualifier("singleRedisClient") RedisClient redisClient){
        return redisClient.connect();
    }
}
