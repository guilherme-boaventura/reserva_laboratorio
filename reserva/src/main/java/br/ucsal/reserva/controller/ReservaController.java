package br.ucsal.reserva.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ucsal.reserva.model.Professor;
import br.ucsal.reserva.model.Reserva;
import br.ucsal.reserva.service.LaboratorioService;
import br.ucsal.reserva.service.ReservaService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/reservaController")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	@PostMapping("/criar-reserva")
	public String createReserva(@RequestParam("data") String data,
								@RequestParam("horario") String horario, 
								@RequestParam("disciplina") String disciplina,  
								@RequestParam("laboratorio") String laboratorio,
															 HttpSession session) throws ParseException {
		
		Date dataReserva = new Date(Integer.valueOf(data.substring(0,4))-1900, Integer.valueOf(data.substring(5,7)) - 1, Integer.valueOf(data.substring(8,10)),
							   Integer.valueOf(horario.substring(0,2)), Integer.valueOf(horario.substring(3,5)));
		
		
		reservaService.criarReserva(new Reserva((Professor) session.getAttribute("user"), disciplina, laboratorioService.getByDescricao(laboratorio), dataReserva));
		
		return "redirect:/home";
	}
	
	@GetMapping("/todasReservas")
	public List<Reserva> getAll() {
		return reservaService.getAll();
	}
	
}
