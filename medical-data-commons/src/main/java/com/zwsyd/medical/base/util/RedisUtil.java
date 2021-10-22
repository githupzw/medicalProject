package com.zwsyd.medical.base.util;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <b>系统基础信息类 - 系统 Redis 工具类</b>
 * @author ZhangWei
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("redisUtil")
public class RedisUtil {
	@Autowired
	private StringRedisTemplate redisTemplate;
	/**
	 * <b>根据 key 将 value 存储到 redis</b>
	 * @param key
	 * @param value
	 * @param expireTimeSecond
	 * @return
	 */
	public boolean setToRedis(String key, Object value, Long expireTimeSecond){
		try {
			// 将用户所给定的 Object 类型的 value 变为 String 类型的 JSON
			JsonMapper jsonMapper = new JsonMapper();
			String valueJSON = jsonMapper.writeValueAsString(value);
			// 将该 JSON 存储到 Redis 中
			redisTemplate.opsForValue().set(key, valueJSON);
			// 设置过期时间
			if (expireTimeSecond == null || expireTimeSecond <= 0) {
				// 此时所设定的时间无效
				expireTimeSecond = BaseConstants.EXPIRE_SECOND;
			}
			redisTemplate.expire(key, expireTimeSecond, TimeUnit.SECONDS);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * <b>根据 Key 获得存储的对象信息</b>
	 * @param key
	 * @param type
	 * @return
	 */
	public Object getFromRedis(String key, Class type) {
		try {
			// 通过 key 从 Redis 中获得对应 JSON
			String valueJSON = redisTemplate.opsForValue().get(key);
			// 判断此时能够获取到对应的 JSON
			if (valueJSON != null && !"".equals(valueJSON)) {
				// 此时存在对应的信息，那么变为对象
				JsonMapper jsonMapper = new JsonMapper();
				Object obj = jsonMapper.readValue(valueJSON, type);
				return obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
