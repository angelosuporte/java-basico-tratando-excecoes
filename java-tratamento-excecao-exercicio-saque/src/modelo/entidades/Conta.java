package modelo.entidades;

import modelo.excecoes.ExcecaoDeDominio;

public class Conta {

	private Integer numeroConta;
	private String titularConta;
	private Double saldoConta;
	private Double limiteSaque;

	public Conta(Integer numeroConta, String titularConta, Double saldoConta, Double saqueConta) {
		this.numeroConta = numeroConta;
		this.titularConta = titularConta;
		this.saldoConta = saldoConta;
		this.limiteSaque = saqueConta;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getTitularConta() {
		return titularConta;
	}

	public void setTitularConta(String titularConta) {
		this.titularConta = titularConta;
	}

	public Double getSaqueConta() {
		return limiteSaque;
	}

	public void setSaqueConta(Double saqueConta) {
		this.limiteSaque = saqueConta;
	}

	public Double getSaldoConta() {
		return saldoConta;
	}

	public void deposito(Double quantiaDeposito) {
		saldoConta += quantiaDeposito;
	}

	public void saque(Double quantiaSaque) throws ExcecaoDeDominio {
		if(saldoConta < quantiaSaque) {
			throw new ExcecaoDeDominio("Saldo da conta insuficiente");
		}
		if(quantiaSaque > limiteSaque) {
			throw new ExcecaoDeDominio("A quantia excede o limite de saque");
		}
		saldoConta -= quantiaSaque;
	}

	public String toString() {
		return "Novo saldo: " 
	            + String.format("%.2f", saldoConta);

	}
}
