package com.wwwy.liuxing.message.util;

import com.wwwy.liuxing.cache.IMovieCache;
import com.wwwy.liuxing.cache.MovieCache;
import com.wwwy.liuxing.system.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/13.
 */
@Service
public class RandomNumUtil {
    public String num;
    private Random random = new Random();
    @Autowired
    private IMovieCache movieCache;

    /**
     * 生成随机短信验证码，并以手机为key存入缓存
     *
     * @param phoneNum
     * @return
     */
    public String setRand(String phoneNum) {
        num = "";
        for (int i = 1; i < 7; i++) {
            String index = random.nextInt(10) + "";
            num += index;
        }
        movieCache.saveValueWithTime(SysConfig.BeforeConfig.PREFIX_MESSAGE + phoneNum, num, SysConfig.BeforeConfig.CODE_SAVE_TIME, TimeUnit.MINUTES);
        return num;
    }

    /**
     * 以手机号查询缓存对应的value
     *
     * @param phoneNum
     * @return
     */
    public String getRand(String phoneNum) {
        String value = movieCache.getValue(SysConfig.BeforeConfig.PREFIX_MESSAGE + phoneNum);
        return value;
    }
}
