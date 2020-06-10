package com.lettuce.lettuce;

import lombok.Data;

/**
 * @ClassName:LettuceSingleProperties
 * @Describe:
 * @Data:2020/6/1010:43
 * @Author:Ago
 * @Version 1.0
 */
@Data
public class LettuceSingleProperties{

    private Integer port;

    private String host;

    private String password;

    private Integer dataBase;
}
