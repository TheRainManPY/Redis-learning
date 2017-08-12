package com.lumi.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by lumi on 17-8-11.
 */
public class JedisDemo1 {

    @Test
    /*
    单实例测试
     */
    public void demo1(){
        // 1.设置IP地址和端口
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        // 2.保存数据
        jedis.set("name", "god");
        // 3.获取数据
        String value = jedis.get("name");
        System.out.print(value);
        // 4.释放资源
        jedis.close();
    }

    @Test
    /*
    连接池方式链接
     */
    public void demo2(){
        // 获得连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大空闲连接数
        config.setMaxIdle(10);

        // 获得连接池
        JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);

        // 获得核心对象
        Jedis jedis = null;
        try{
            // 通过连接池获得链接
            jedis = jedisPool.getResource();
            // 设置数据
            jedis.set("name", "nike");
            // 获取数据
            String name = jedis.get("name");
            System.out.print(name);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 释放资源
            if (jedis != null){
                jedis.close();
            }
            if (jedisPool != null){
                jedisPool.close();
            }
        }
    }
}
