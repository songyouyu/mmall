package com.mmall.common;

import com.mmall.util.PropertiesUtil;
import redis.clients.jedis.*;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;


import java.util.ArrayList;
import java.util.List;

/**
 * created by song on 2018/1/21
 */
public class RedisShardedPool {

    //statis保证在tomcat启动时就加载出来
    private static ShardedJedisPool shardedJedisPool;//sharded jedis连接池
    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.max.total", "20"));//jedis连接池和redis-server最大连接数
    private static Integer maxIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.max.idle", "20"));//jedispool中最大空闲状态的jedis实例的个数
    private static Integer minIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.min.idle", "10"));
    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.borrow", "true"));//在jedispool中获取一个Jedis实例的时候，是否进行验证操作，若赋值为true,则得到的jedis的实例肯定是可以用的
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.return", "false"));//在向jedispool中返还一个Jedis实例的时候，是否进行验证操作，若赋值为true,则返还的jedis的实例肯定是可以用的

    private static String redis1Ip = PropertiesUtil.getProperty("redis1.ip");
    private static Integer redis1Port = Integer.parseInt(PropertiesUtil.getProperty("redis1.port"));
    private static String redis2Ip = PropertiesUtil.getProperty("redis2.ip");
    private static Integer redis2Port = Integer.parseInt(PropertiesUtil.getProperty("redis2.port"));

    private static void initPool(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);

        config.setTestOnBorrow(testOnBorrow);
        config.setTestOnReturn(testOnReturn);
        config.setBlockWhenExhausted(true);//连接池中没有多余连接时，是否阻塞，false会跑出异常，true阻塞直到超时，默认为truue.

        JedisShardInfo info1 = new JedisShardInfo(redis1Ip, redis1Port, 1000 * 2);
        JedisShardInfo info2 = new JedisShardInfo(redis2Ip, redis2Port, 1000 * 2);

        List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>(2);
        jedisShardInfoList.add(info1);
        jedisShardInfoList.add(info2);
        shardedJedisPool = new ShardedJedisPool(config, jedisShardInfoList, Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN);
    }

    static {
        initPool();
    }

    public static ShardedJedis getShardedJedis() {
        return shardedJedisPool.getResource();
    }

    public static void returnResource(ShardedJedis shardedJedis) {
        shardedJedisPool.returnResource(shardedJedis);
    }

    public static void returnBrokenResource(ShardedJedis shardedJedis) {
        shardedJedisPool.returnBrokenResource(shardedJedis);
    }

    public static void main(String[] args) {
        ShardedJedis shardedJedis = shardedJedisPool.getResource();
        for (int i = 0; i < 10; i++) {
            shardedJedis.set("key" + i, "value" + i);
        }

        returnResource(shardedJedis);
        //shardedJedisPool.destroy();//临时调用，销毁连接池中所有连接
        System.out.println("program is end");
    }
}
