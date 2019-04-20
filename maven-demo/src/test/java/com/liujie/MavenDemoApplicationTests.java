package com.liujie;

import com.liujie.mavendemo.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MavenDemoApplicationTests {
	@Autowired
	private Demo demo;


	@Test
	public void contextLoads() {
		demo.demo("刘姐");
	}

}
