package com.javapractice.prueba;

import com.javapractice.prueba.model.Game;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaApplication {



	public static void main(String[] args) {
		Game juego1 = new Game();
		SpringApplication.run(PruebaApplication.class, args);
	}

}
