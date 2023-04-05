package br.ucsal.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.reserva.model.Laboratorio;

@Repository
public interface LaboratorioRepository extends JpaRepository<Laboratorio,Long>{

}
