package br.com.cadastruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.cadastruser.dao"})
public class CadastrUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastrUserApplication.class, args);
		
	}

}
