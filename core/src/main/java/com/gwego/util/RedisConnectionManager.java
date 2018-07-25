package com.gwego.util;

import org.apache.commons.io.FileUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liudongxu06
 * @date 2018/7/25
 */
public class RedisConnectionManager {

    private static Map<String, JedisPool> poolMap = new ConcurrentHashMap<String, JedisPool>();
    private static String defaultName = "default";

    private static JedisPool jedisPool;

    public static Jedis getConnection(String name) {
        JedisPool pool;
        if ((pool = poolMap.get(name)) != null) {
            return pool.getResource();
        } else {
            throw new RuntimeException("Can't found this name " + name + "in redis connection pool!");
        }

    }

    public static void returnResource(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

    private static void init(){

    }

    public static void test() throws IOException {
        URL url = RedisConnectionManager.class.getClassLoader().getResource("redis.json");
        String str = FileUtils.readFileToString(new File(url.getFile()),"UTF-8");
        System.out.println(str);
    }
}
