package com.example.TecnicasAPS.repositorio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.TecnicasAPS.entidades.Conta;

@Repository
public class ContaRepositorio {

	@Autowired
	private ArrayList<Conta> listaConta;

	public void adicionar(Conta conta) {
		this.listaConta.add(conta);
	}

	public ArrayList<Conta> listar() {
		return listaConta;
	}
}
