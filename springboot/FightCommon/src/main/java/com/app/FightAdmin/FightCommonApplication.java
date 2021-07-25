package com.app.FightAdmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = { HibernateJpaAutoConfiguration.class })
@EnableEurekaClient
@ComponentScan(basePackages = { "com.app.FightAdmin" })
@EntityScan(basePackages = { "com.app.FightAdmin" })
public class FightCommonApplication {

	public static void main(String[] args) {
		SpringApplication.run(FightCommonApplication.class, args);
	}

}
