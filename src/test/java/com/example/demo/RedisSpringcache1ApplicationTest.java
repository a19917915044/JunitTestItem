package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisSpringcache1ApplicationTest {
	@Autowired
	StringRedisTemplate redisTemplate;
	@Autowired
	AuthUserRepository authUserRepository;
	
	
	@Test
	public void contextLoads1() {
		System.out.println("第二个测试任务");
	}
	@Test
	public void contextLoads2() {
		System.out.println("第三个测试任务");
	}
	@Test
	public void contextLoads() {

		Assert.assertNotNull(redisTemplate);
//		
		String xx = redisTemplate.opsForValue().get("authuser::findByAccount[account1]");
		System.out.println(xx);

		redisTemplate.opsForValue().set("hello", "world");
		String value = redisTemplate.opsForValue().get("hello");
		System.out.println("value = " + value);
		redisTemplate.delete("hello");

		value = redisTemplate.opsForValue().get("hello");
		System.out.println("value = " + value);
		
		
		
		AuthUser authUser = authUserRepository.findByAccount("account1");
		System.out.println(authUser);
//		
		
		
//		authUserRepository.deleteById(authUser.getId());
		
	}
	
}
