package model.entities;

import java.io.Serializable;

public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String CPF;
	private String nome;
	private String sobrenome;
	private String usuario;
	private String senha;
	private Double saldo;
	
	private Familia planoFamilia;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, String cPF, String nome, String sobrenome, String usuario, String senha,Double saldo,
			Familia planoFamilia ) {
		super();
		this.id = id;
		CPF = cPF;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.usuario = usuario;
		this.senha = senha;
		this.saldo = saldo;
		
		this.planoFamilia = planoFamilia;
		
	}
	
	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Familia getPlanoFamilia() {
		return planoFamilia;
	}

	public void setPlanoFamilia(Familia planoFamilia) {
		this.planoFamilia = planoFamilia;
	}
	
	

}
