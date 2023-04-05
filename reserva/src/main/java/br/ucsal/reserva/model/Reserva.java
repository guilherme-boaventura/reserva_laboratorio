package br.ucsal.reserva.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="RESERVAS")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	Professor professor;
	
	@Column(nullable=false)
	String disciplina;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	Laboratorio laboratorio;

	@DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
	@Column(nullable=false)
	Date data;
	
	Boolean aprovada;
	
	public Reserva() {
	}
	
	public Reserva(Professor professor, String disciplina, Laboratorio laboratorio, Date data) {
		this();
		this.professor = professor;
		this.disciplina = disciplina;
		this.laboratorio = laboratorio;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Date getData() {
		return data;
	}
	
	public String getDataFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getAprovada() {
		return aprovada;
	}

	public void setAprovada(Boolean aprovada) {
		this.aprovada = aprovada;
	}
}
