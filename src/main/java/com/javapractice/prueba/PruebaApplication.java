package com.javapractice.prueba;

import com.javapractice.prueba.model.Game;
import com.javapractice.prueba.model.GamePlayer;
import com.javapractice.prueba.model.Player;
import com.javapractice.prueba.model.Ship;
import com.javapractice.prueba.repository.GamePlayerRepository;
import com.javapractice.prueba.repository.GameRepository;
import com.javapractice.prueba.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class PruebaApplication {


	public static void main(String[] args) {

		SpringApplication.run(PruebaApplication.class, args);
	}


	@SpringBootApplication
	public class SalvoApplication {



	}

}




