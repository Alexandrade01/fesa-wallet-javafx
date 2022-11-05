package model.entities;

import java.io.Serializable;

public class MetodoPagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private Double saldo;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public MetodoPagamento(String descricao, Double saldo) {
		super();
		this.descricao = descricao;
		this.saldo = saldo;
	}

}
