package com.example.TecnicasAPS.entidades;

public class Extrato {

	private String operacao;
	private Double valor;

	public Extrato(String operacao, Double valor) {
		this.operacao = operacao;
		this.valor = valor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

}
