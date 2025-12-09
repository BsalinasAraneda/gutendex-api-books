package com.practicaspring.apibooks;

import com.practicaspring.apibooks.Principal.LanzarLibros;
import com.practicaspring.apibooks.service.ConsumoAPI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApibooksApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ApibooksApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		LanzarLibros lanzarLibros = new LanzarLibros();
		lanzarLibros.LanzarApi();
	}
}
