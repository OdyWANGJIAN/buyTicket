package com.wwwy.liuxing.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/11.
 */
@Repository
public class MovieCache implements IMovieCache {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void saveHash(String key, Map<Object, Object> value) {
//        Map<String, Object> hashMap = new HashMap<>();
        redisTemplate.opsForHash().putAll(key, value);
    }

    @Override
    public Map<Object, Object> queryHashByKey(String key) {
        Map<Object, Object> map = redisTemplate.opsForHash().entries(key);
        return map;
    }

    @Override
    public void saveList(String key, List list) {
        redisTemplate.opsForList().rightPushAll(key, list);
        redisTemplate.expire(key,14,TimeUnit.MINUTES);
    }

    @Override
    public List getAllByKey(String key) {
        List<String> resultList = redisTemplate.opsForList().range(key, 0, -1);
        return resultList;
    }

    @Override
    public void saveValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void saveValueWithTime(String key, String value, long num, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, num, unit);
    }
}
