package com.wwwy.liuxing.redis.test;

import com.wwwy.liuxing.cache.IMovieCache;
import com.wwwy.liuxing.message.util.RandomNumUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-core.xml")
public class RedisTest {
    private Logger logger= Logger.getLogger(RedisTest.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RandomNumUtil randomNumUtil;
    @Autowired
    private IMovieCache movieCache;
    @Test
    public void testCase1(){
        stringRedisTemplate.opsForValue().set("username","xiaoming",1, TimeUnit.MINUTES);
    }
    @Test
    public void testCase2(){
        String rand = randomNumUtil.setRand("1243");
        logger.info(rand);
        movieCache.getValue("1243");
    }
}
