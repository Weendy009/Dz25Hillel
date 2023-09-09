package com.dota.database.Dotawiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.dota.database.Dotawiki.repository")
@EntityScan("com.dota.database.Dotawiki.entity")
public class DotaWikiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotaWikiApplication.class, args);
	}

}
