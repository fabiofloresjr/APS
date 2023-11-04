package com.example.TecnicasAPS.visualizacao;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.TecnicasAPS.entidades.Conta;
import com.example.TecnicasAPS.servicos.ContaServico;
import com.example.TecnicasAPS.servicos.ExtratoServico;

@Component
public class Programa implements CommandLineRunner {

	@Autowired
	private ContaServico contaServico;

	@Autowired
	private ExtratoServico extratoServico;

	@Override
	public void run(String... args) throws Exception {
		try (Scanner teclado = new Scanner(System.in)) {
			Conta conta = new Conta();
			System.out.println("Digite o saldo da conta");
			conta.setSaldo(teclado.nextDouble());
			while (true) {
				System.out.println("Você quer ->depositar<- ou ->sacar<-?");
				String resposta = teclado.next();
				if (resposta.equals("sacar")) {
					System.out.println("Quanto você quer sacar?");
					contaServico.sacar(conta, teclado.nextDouble());
					contaServico.salvar(conta);
				} else if (resposta.equals("depositar")) {
					System.out.println("Quanto você quer depositar?");
					contaServico.depositar(conta, teclado.nextDouble());
					contaServico.salvar(conta);
				} else {
					System.out.println("Opção inválida.");
				}

				for (String extratoIterador : extratoServico.listar()) {
					System.out.println(extratoIterador);
				}
				System.out.println("Saldo da conta: " + conta.getSaldo());
			}
		}

	}

}