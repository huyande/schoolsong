package com.zwxq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolsongApplicationTests {

	@Test
	public void contextLoads() {
		Integer f1=100,f2=100,f3=150,f4=150;
		System.out.println(f1==f2);
		System.out.println(f3=f4);
	}

}
