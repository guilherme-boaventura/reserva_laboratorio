package br.ucsal.reserva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.reserva.model.Reserva;
import br.ucsal.reserva.service.ReservaService;

@Controller
@RequestMapping("/reservaController")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@PostMapping("/reservar")
	public String createReserva(Reserva reserva) {
		reservaService.salvar(reserva);
		return "redirect:/home";
	}
	
	@GetMapping("/todasReservas")
	public List<Reserva> getAll() {
		return reservaService.getAll();
	}
	
}
