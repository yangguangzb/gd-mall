package com.gd.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;
import com.gd.dao.JedisClient;

public class JedisClientCluster implements JedisClient {
	
	@Autowired
	private JedisCluster jedisCluster;
	
	public String get(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.get(key);
	}

	public String set(String key, String value) {
		// TODO Auto-generated method stub
		return jedisCluster.set(key, value);
	}

	public String hget(String hkey, String key) {
		// TODO Auto-generated method stub
		return jedisCluster.hget(hkey, key);
	}

	public long hset(String hkey, String key, String value) {
		// TODO Auto-generated method stub
		return jedisCluster.hset(hkey, key, value);
	}

	public long incr(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.incr(key);
	}

	public long expire(String key, int second) {
		// TODO Auto-generated method stub
		return jedisCluster.expire(key, second);
	}

	public long ttl(String key) {
		// TODO Auto-generated method stub
		return jedisCluster.ttl(key);
	}
	
	public long del(String key){
		return jedisCluster.del(key);
	}
	
	public long hdel(String hkey, String key) {
		
		return jedisCluster.hdel(hkey, key);
	}
}
