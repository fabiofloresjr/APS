package com.example.TecnicasAPS.validadores;

import org.springframework.stereotype.Component;

import com.example.TecnicasAPS.entidades.Conta;

@Component
public class ContaValidador {

	public void validarSaque(Conta conta, Double quantia) throws Exception {
		if (quantia > conta.getSaldo())
			throw new Exception("A tentativa de saque é maior que o saldo da conta");
	}
}
