package br.ucsal.reserva.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.reserva.model.Laboratorio;
import br.ucsal.reserva.repository.LaboratorioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class LaboratorioService {

	@Autowired
	private EntityManager em;
	
	@Autowired
	private LaboratorioRepository repo;
	
	public Laboratorio getByDescricao(String descricao) {
		
		Query sql = em.createQuery("FROM Laboratorio p WHERE p.descricao = '" + descricao + "'");
		
		Stream<Laboratorio> result = sql.getResultStream();
		try {
			return result.findFirst().get();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Laboratorio> getAll() {
		return repo.findAll();
	}
		
}