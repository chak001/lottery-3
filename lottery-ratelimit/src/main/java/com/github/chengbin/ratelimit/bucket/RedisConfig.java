package com.github.chengbin.ratelimit.bucket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhangcb
 * @created 2018-01-30 13:53.
 */
@Configuration
public class RedisConfig {
    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        return new JedisPool(jedisPoolConfig, jedisConnectionFactory.getHostName(), 6379, 0, jedisConnectionFactory.getPassword());
    }
}
