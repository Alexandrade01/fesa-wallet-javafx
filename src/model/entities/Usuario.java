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
	private PlanoFamilia planoFamilia;
	
	public Usuario(Integer id, String cPF, String nome, String sobrenome, String usuario, String senha,
			PlanoFamilia planoFamilia) {
		super();
		this.id = id;
		CPF = cPF;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.usuario = usuario;
		this.senha = senha;
		this.planoFamilia = planoFamilia;
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

	public PlanoFamilia getPlanoFamilia() {
		return planoFamilia;
	}

	public void setPlanoFamilia(PlanoFamilia planoFamilia) {
		this.planoFamilia = planoFamilia;
	}
	
	

}
