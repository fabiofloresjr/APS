package com.example.TecnicasAPS.repositorio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.TecnicasAPS.entidades.Extrato;

@Repository
public class ExtratoRepositorio {

	@Autowired
	private ArrayList<String> listaExtrato;

	public void adicionar(Extrato extrato) {
		this.listaExtrato.add("Operação: " + extrato.getOperacao() + " - Valor:" + extrato.getValor());
	}

	public ArrayList<String> listar() {
		return listaExtrato;
	}
}
