package com.example.TecnicasAPS.servicos;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TecnicasAPS.entidades.Extrato;
import com.example.TecnicasAPS.repositorio.ExtratoRepositorio;

@Service
public class ExtratoServico {

	@Autowired
	private ExtratoRepositorio extratoRepositorio;

	public void salvar(Extrato extrato) throws Exception {
		extratoRepositorio.adicionar(extrato);
	}

	public ArrayList<String> listar() {
		return extratoRepositorio.listar();
	}
}
