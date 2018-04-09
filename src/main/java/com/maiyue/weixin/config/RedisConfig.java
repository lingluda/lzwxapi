package com.maiyue.weixin.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maiyue.weixin.redis.CustomSerializable;
import com.maiyue.weixin.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.io.Serializable;

/**
 *
 * @author huang
 * @date 2017/12/25
 */

@Configuration
@EnableCaching
public class RedisConfig{

    @Bean(name="jedisPoolConfig")
    @ConfigurationProperties(prefix="spring.redis")
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean(name="jedisConnectionFactory")
    @ConfigurationProperties(prefix="spring.redis")
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        JedisPoolConfig config = jedisPoolConfig();
        factory.setPoolConfig(config);
        return factory;
    }


    /**
     * Spring Data Redis支持JDK序列化、Json序列化、XML序列化
     - JDK序列化：默认采用JDK序列化方式的类JdkSerializationRedisSerializer，速度快但占用空间较大,对象必须实现java.io.Serializable接口
     - Json序列化：空间占用小，包括GenericJackson2JsonRedisSerializer和Jackson2JsonRedisSerializer 两种，其中GenericJackson2JsonRedisSerializer无需为各种类型单独定义Bean
     - XML序列化：OxmSerializer ，速度慢空间占用较大
     * @return
     */

    
    
	/**
     * JDK序列化
     * @return
     */
    @Bean(name="redisTemplate")
    @SuppressWarnings("rawtypes")
    public RedisTemplate<Serializable, ?> redisTemplate(
    		@Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory,
    		@Qualifier("stringSerializer") StringRedisSerializer keySerializer,
            @Qualifier("customSerializable") CustomSerializable customSerializable){
    	
        RedisTemplate<Serializable, ?> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        
        
        template.setValueSerializer(customSerializable);
        template.setHashValueSerializer(customSerializable);
        
        template.setKeySerializer(keySerializer);
        
        template.afterPropertiesSet();
        return template;
    }


    /**
     *  JSON序列化
     * @return
     */
    @Bean(name="jsonRedisTemplate")
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public RedisTemplate<Serializable, ?> jsonRedisTemplate(
    	   @Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory,
           @Qualifier("stringSerializer") StringRedisSerializer keySerializer) {
    	
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(jedisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setKeySerializer(keySerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    
    @Bean(name="jdkSerializer")
    public JdkSerializationRedisSerializer jdkSerializer(){
        JdkSerializationRedisSerializer jdkSerializer = new JdkSerializationRedisSerializer();
        return jdkSerializer;
    }


    @Bean(name="stringSerializer")
    public StringRedisSerializer stringSerializer(){
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        return stringRedisSerializer;
    }

    @SuppressWarnings("rawtypes")
	@Bean(name="customSerializable")
    public CustomSerializable customSerializable(){
        CustomSerializable customSerializable = new CustomSerializable();
        return customSerializable;
    }
    
    
    /*@SuppressWarnings("rawtypes")
	@Bean(name="kryoSerializable")
    public KryoSerializable kryoSerializable() {
    	KryoSerializable kryoSerializable = new KryoSerializable();
		return kryoSerializable;
	}*/

    
    
    @Bean(name="redisUtil")
    @SuppressWarnings({"unchecked","rawtypes"})
    public RedisUtil redisUtil(@Qualifier("redisTemplate")RedisTemplate redisTemplate) {
		RedisUtil redisUtil = new RedisUtil(redisTemplate);
        return redisUtil;
    }

}
