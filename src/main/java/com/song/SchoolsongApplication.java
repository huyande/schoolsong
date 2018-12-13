package com.song;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class}
@MapperScan("com.song.dao")
public class SchoolsongApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolsongApplication.class, args);
	}
}	
