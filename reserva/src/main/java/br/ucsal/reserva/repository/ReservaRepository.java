package br.ucsal.reserva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ucsal.reserva.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long>{

}