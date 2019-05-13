//package com.miquankj.common.cache;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.lang.reflect.Method;
//
//
///**
// * redis配置
// * @author liuyadong
// * @since 2019/5/11
// */
//@Configuration
//@EnableCaching
//public class RedisConfig extends CachingConfigurerSupport {
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(method.getReturnType().getSimpleName());
//                for (Object obj : params) {
//                    sb.append("_");
//                    sb.append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//
//    /**
//     *自定义springSessionDefaultRedisSerializer对象，将会替代默认的SESSION序列化对象。
//     * @return
//     */
//    @Bean(name = "springSessionDefaultRedisSerializer")
//    public GenericJackson2JsonRedisSerializer getGenericJackson2JsonRedisSerializer() {
//        return new GenericJackson2JsonRedisSerializer();
//    }
//
//    /**
//     * 根据model的id生成缓存的key值
//     * @return
//     */
//    @Bean
//    public KeyGenerator keyGeneratorModelId() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(method.getReturnType().getSimpleName());
//
////                for (Object object : params) {
////                    sb.append("_");
////                    BaseEntity model = (BaseEntity)object;
////                    sb.append(model.getId());
////                }
//
//                return sb.toString();
//            }
//        };
//    }
//
//    @SuppressWarnings("rawtypes")
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new SpringRedisCacheManager(redisTemplate);
//        //设置缓存过期时间
//        //rcm.setDefaultExpiration(60);//秒
//        return rcm;
//    }
//
////    @Bean
////    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
////        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
////        redisTemplate.setConnectionFactory(connectionFactory);
////
////        // 使用Jackson2JsonRedisSerialize 替换默认序列化
////        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer =
////                new Jackson2JsonRedisSerializer(Object.class);
////
////        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
////        // 设置value的序列化规则和 key的序列化规则
////        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
////        redisTemplate.setKeySerializer(new StringRedisSerializer());
////
////        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
////        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
////
////        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
////        redisTemplate.setEnableDefaultSerializer(true);
////        redisTemplate.afterPropertiesSet();
////        return redisTemplate;
////    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        StringRedisTemplate template = new StringRedisTemplate(factory);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.afterPropertiesSet();
//        return template;
//    }
//}
