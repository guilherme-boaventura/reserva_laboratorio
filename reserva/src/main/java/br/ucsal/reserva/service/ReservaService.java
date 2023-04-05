package br.ucsal.reserva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.reserva.model.Reserva;
import br.ucsal.reserva.repository.ReservaRepository;

@Service
public class ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	public Reserva criarReserva(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	public void deletar(Reserva reserva) {
		reservaRepository.delete(reserva);
	}
	
	public Reserva getById(Long id) {
		return reservaRepository.findById(id).orElseGet(null);
	}
	
	public List<Reserva> getAll() {
		return reservaRepository.findAll();
	}
}