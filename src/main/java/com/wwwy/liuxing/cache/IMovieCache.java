package com.wwwy.liuxing.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018/4/11.
 */
public interface IMovieCache {
    /**
     * 根据key值，Map存入缓存
     * @param key
     * @return
     */
    void saveHash(String key, Map<Object, Object> value);
    /**
     * 根据key值，获取缓存对应的Map
     * @param key
     * @return
     */
    Map<Object, Object> queryHashByKey(String key);
    /**
     * 根据key值，将list存入缓存
     * @param key
     * @return
     */
    void saveList(String key, List list);

    /**
     * 根据key值，获取缓存对应的list
     * @param key
     * @return
     */
    List getAllByKey(String key);
    /**
     * 通过key将value值存入缓存
     * @param key
     * @return
     */
    void saveValue(String key, String value);

    /**
     * 通过key获取缓存中对应的value值
     * @param key
     * @return
     */
    String getValue(String key);

    void saveValueWithTime(String key, String value, long num, TimeUnit unit);
}
