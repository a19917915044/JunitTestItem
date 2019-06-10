package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySuperTest {
	
	@Test
	public void contextLoads1() {
		System.out.println("第四个测试任务");
	}
	@Test
	public void contextLoads2() {
		System.out.println("第五个测试任务");
	}
	
}
