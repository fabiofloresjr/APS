package com.example.TecnicasAPS.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.TecnicasAPS.entidades.Conta;

@Configuration
public class ConfigBeans {

	@Bean
	public ArrayList<Conta> criarListaConta() {
		return new ArrayList<>();
	}

	@Bean
	public ArrayList<String> criarListaExtrato() {
		return new ArrayList<>();
	}
}
