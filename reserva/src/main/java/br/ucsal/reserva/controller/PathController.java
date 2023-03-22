package br.ucsal.reserva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ucsal.reserva.service.ReservaService;

@Controller
public class PathController {

	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("Index");
		mv.addObject("reservas", reservaService.getAll());
		return mv;
	}

	@GetMapping("/reserva")
	public String reserva() {
		return "Reserva";
	}
	
}