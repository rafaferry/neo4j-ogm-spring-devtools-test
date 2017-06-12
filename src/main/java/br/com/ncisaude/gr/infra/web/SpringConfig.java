package br.com.ncisaude.gr.infra.web;

import org.neo4j.ogm.config.Configuration.Builder;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableScheduling
@EntityScan("br.com.ncisaude.gr.dominio")
public class SpringConfig {

	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		Builder builder = new org.neo4j.ogm.config.Configuration.Builder();
		builder
				.autoIndex("assert")
				.uri("bolt://localhost")
				.credentials("neo4j", "eduasicn");
		return builder.build();
	}

}
