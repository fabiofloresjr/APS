package com.example.TecnicasAPS.servicos;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TecnicasAPS.entidades.Conta;
import com.example.TecnicasAPS.entidades.Extrato;
import com.example.TecnicasAPS.repositorio.ContaRepositorio;
import com.example.TecnicasAPS.validadores.ContaValidador;

@Service
public class ContaServico {

	@Autowired
	private ContaRepositorio contaRepositorio;

	@Autowired
	private ExtratoServico extratoServico;

	@Autowired
	private ContaValidador contaValidador;

	public void salvar(Conta conta) throws Exception {
		contaRepositorio.adicionar(conta);
	}

	public void sacar(Conta conta, Double quantia) throws Exception {
		contaValidador.validarSaque(conta, quantia);
		conta.setSaldo(conta.getSaldo() - quantia);
		extratoServico.salvar(new Extrato("Saque", quantia));
	}

	public void depositar(Conta conta, Double quantia) throws Exception {
		depositoMaiorQueMil(conta, quantia);
		conta.setSaldo(conta.getSaldo() + quantia);
		extratoServico.salvar(new Extrato("Depósito", quantia));
	}

	private void depositoMaiorQueMil(Conta conta, Double quantia) {
		if (quantia > 1000) {
			conta.setSaldo(conta.getSaldo() + 5);
			System.out.println("Bônus de 5 reais por ter depositado um valor acima de R$1000.0!");
		}
	}

	public ArrayList<Conta> listar() {
		return contaRepositorio.listar();
	}
}
