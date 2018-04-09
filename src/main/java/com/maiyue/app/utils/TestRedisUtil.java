package com.maiyue.app.utils;

import com.maiyue.app.redis.CustomSerializable;
import redis.clients.jedis.Jedis;

/**
 * Created by huang on 2017/1/9.
 */
public class TestRedisUtil<T> {

    private Jedis jedis;

    public TestRedisUtil() {
        jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("huang");
    }

    public boolean set(String key,T value){
        CustomSerializable<T> customSerializable = new CustomSerializable<>();
        jedis.set(key.getBytes(),customSerializable.serialize(value));
        return false;
    }

    public T get(String key){
        CustomSerializable<T> customSerializable = new CustomSerializable<>();
        return customSerializable.deserialize(jedis.get(key.getBytes()));
    }

    public Long remove(String key){
        Long flag = jedis.del(key);
        return flag;
    }
}
