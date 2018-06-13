package com.eleven.toolkit.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.eleven.toolkit.GsonUtils;
import com.eleven.toolkit.ToolKit;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;

/**
 * 本地配置项缓存类, 简化不同的配置项操作
 */
public class ConfigCache implements Serializable {

    public static interface ConfigAction<T> {

        void doConfig(T config);
    }


    /**
     * 配置项缓存,key为类名，value为配置项instance
     */
    HashMap<String, Object> mConfigMap = new HashMap<>();

    public static <T> T defaultConfig(Class<T> cls) {
        return defaultConfig(cls, true);
    }

    public static <T> T defaultConfig(Class<T> cls, boolean needDefault) {
        String key = getCacheKey(cls);
        if (getInstance().mConfigMap.containsKey(key)) {
            return (T) getInstance().mConfigMap.get(key);
        }

        try {
            T instance = createConfigInstanceFromCache(cls);
            if (instance == null && needDefault) {
                instance = cls.newInstance();
            }

            if (instance != null)
                getInstance().mConfigMap.put(key, instance);
            return instance;

        } catch (Throwable e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 清除配置类缓存
     *
     * @param cls 　配置类
     */
    public static void deleteConfig(Class cls) {
        getInstance().mConfigMap.remove(getCacheKey(cls));
        SharedPreferences sp = ToolKit.getApp().getSharedPreferences(getCacheKey(cls), Context.MODE_PRIVATE);
        SPUtils.apply(sp.edit().remove("content"));
    }

    public static <T> void config(Class<T> cls, ConfigAction<T> action) {
        T config = defaultConfig(cls);
        if (action != null) {
            action.doConfig(config);
            save(config);
        }
    }

    /**
     * 保存配置
     *
     * @param config 配置项instance
     */
    public static void save(Object config) {
        SharedPreferences sp = ToolKit.getApp().getSharedPreferences(getCacheKey(config.getClass()), Context.MODE_PRIVATE);
        SPUtils.apply(sp.edit().putString("content", GsonUtils.toJson(config)));
        getInstance().mConfigMap.remove(getCacheKey(config.getClass()));
    }

    private static <T> T createConfigInstanceFromCache(Class<T> cls) {
        SharedPreferences sp = ToolKit.getApp().getSharedPreferences(getCacheKey(cls), Context.MODE_PRIVATE);
        String content = sp.getString("content", null);
        if (TextUtils.isEmpty(content)) {
            return null;
        } else {
            return GsonUtils.fromJson(content, cls);
        }
    }

    private static String getCacheClassName(Class cls) {
        Annotation annotation = cls.getAnnotation(CacheKey.class);
        if (annotation != null) {
            CacheKey cacheKey = (CacheKey) annotation;
            return cacheKey.key();
        } else {
            return cls.getName();
        }
    }

    private static String getCacheKey(Class cls) {
        return getCacheClassName(cls);
    }

    private static ConfigCache sSharedInstance;

    private static ConfigCache getInstance() {
        if (sSharedInstance == null) {
            sSharedInstance = new ConfigCache();
        }
        return sSharedInstance;
    }


}