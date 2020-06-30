package com.lettuce.lettuce.codec;

import io.lettuce.core.codec.RedisCodec;

import java.nio.ByteBuffer;

/**
 * @ClassName:LettuceCodec
 * @Describe:
 * @Data:2020/6/1014:59
 * @Author:Ago
 * @Version 1.0
 */
public class LettuceCodec implements RedisCodec {
    @Override
    public Object decodeKey(ByteBuffer byteBuffer) {
        return null;
    }

    @Override
    public Object decodeValue(ByteBuffer byteBuffer) {
        return null;
    }

    @Override
    public ByteBuffer encodeKey(Object o) {
        return null;
    }

    @Override
    public ByteBuffer encodeValue(Object o) {
        return null;
    }
}
