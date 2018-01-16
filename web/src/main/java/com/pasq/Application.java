package com.pasq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author 王伟鑫
 * @version 0.1v
 * @create 2018/1/16 13:58
 * @see
 */
@SpringBootApplication
@EnableCaching
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
