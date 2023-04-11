package br.ucsal.reserva.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PROFESSORES")
public class Professor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String disciplina;
	
	@Column(nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private Boolean admin;
	
	public Professor() {
		
	}
	
	public Professor(String nome, String disciplina, String login, String senha, String email, Boolean admin) {
		super();
		this.nome = nome;
		this.disciplina = disciplina;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getPrimeiroNome() {
		String[] nomeDividido = nome.split(" ");
		return nomeDividido[0];
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}