package br.gov.sp.fatec.clinica.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("br.gov.sp.fatec.clinica.model")
@EnableJpaRepositories("br.gov.sp.fatec.clinica.repository")
@SpringBootApplication(scanBasePackages = { 
		"br.gov.sp.fatec.clinica.api",
		"br.gov.sp.fatec.clinica.model",
		"br.gov.sp.fatec.clinica.repository",
		"br.gov.sp.fatec.clinica.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
