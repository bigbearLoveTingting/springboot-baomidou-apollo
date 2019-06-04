package com.greatwall.business.controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import xingkong.tool.core.ResponseTool;
import xingkong.tool.core.web.vo.ResponseVo;

/**
 *
 * @author xingkong
 */
@Slf4j
@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * 设置redis测试
	 * @return
	 */
	@RequestMapping("/set")
	public ResponseVo set() {
		try {
			redisTemplate.opsForValue().set("test", "test");
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseTool.error("设置Redis失败");
		}

		return ResponseTool.success();
	}

	/**
	 * 获取redis测试
	 * @return
	 */
	@RequestMapping("/get")
	public ResponseVo get() {
		ResponseVo response = null;
		try {
			response = new ResponseVo(redisTemplate.opsForValue().get("test"));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseTool.error("获取Redis数据失败");
		}
		return response;
	}

}
