package com.lettuce.lettuce;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Conditional;

/**
 * @ClassName:LettuceProperties
 * @Describe:
 * @Data:2020/6/1010:38
 * @Author:Ago
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "lettuce")
public class LettuceProperties {

    private LettuceSingleProperties single;

    /*
    private LettuceReplicaProperties replica;
    private LettuceSentinelProperties sentinel;
    private LettuceClusterProperties cluster;
    */
}
