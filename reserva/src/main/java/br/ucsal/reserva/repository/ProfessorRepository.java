package br.ucsal.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.reserva.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long>{

}
