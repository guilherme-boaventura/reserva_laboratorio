package br.ucsal.reserva.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.reserva.model.Laboratorio;
import br.ucsal.reserva.model.Professor;
import br.ucsal.reserva.repository.ProfessorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository repo;

	@Autowired
	private EntityManager em;
	
	public Professor getByLoginSenha(String login, String senha) {
		Query sql = em.createQuery("FROM Professor p WHERE p.login='" + login + "' AND p.senha='" + senha + "'");
		Stream<Professor> result = sql.getResultStream();
		try {
			return result.findFirst().get();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Professor cadastrar(String nome,String email,String login,String senha,String disciplina,Boolean admin) {
		Professor professor = new Professor(nome,disciplina,login,senha,email,(admin) ? admin : false);
		return repo.save(professor);
	}
	
}
