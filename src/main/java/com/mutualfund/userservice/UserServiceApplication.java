package com.mutualfund.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.mutualfund.commonentity.entities")
@EnableJpaRepositories(basePackages = "com.mutualfund.commonrepo.repository")
@ComponentScan(basePackages = {
		"com.mutualfund.userservice",
		"com.mutualfund.commonrepo",
		"com.mutualfund.commonentity"
})
//@EnableJpaRepositories(basePackages = "com.mutualfund.commonrepo.repository")
public class UserServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
	}

}
