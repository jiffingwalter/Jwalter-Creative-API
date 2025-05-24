package com.jiffingwalter.jwalter_creative_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class })
public class JwalterCreativeAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwalterCreativeAPIApplication.class, args);
	}

}
