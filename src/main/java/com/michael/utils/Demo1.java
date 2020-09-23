package com.michael.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		
		JedisShardInfo shardInfo = new JedisShardInfo("redis://127.0.0.1:6379");//这里是连接的本地地址和端口
	    shardInfo.setPassword("123456");//这里是密码
	    Jedis jedis = new Jedis(shardInfo);
	    jedis.connect();
		// 1. 设置IP地址和端口
//        Jedis jedis = new Jedis("127.0.0.1",6379);
        // 2. 保存数据
        jedis.set("name3","michael3", "NX", "EX", 2);
        System.out.println(jedis.get("name3"));
        Thread.sleep(3000);
        // 3. 获取数据
        String value = jedis.get("name3");
        System.out.println(value);
        // 4.释放资源
        jedis.close();
        
	}

}
