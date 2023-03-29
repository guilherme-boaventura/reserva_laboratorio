package br.ucsal.reserva.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ucsal.reserva.service.ReservaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class PathController {

	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public ModelAndView inicio(HttpSession session) {
		ModelAndView mv = new ModelAndView("Index");
		mv.addObject("reservas", reservaService.getAll());
		mv.addObject("user", session.getAttribute("user"));
		mv.addObject("authError", session.getAttribute("authError"));
		return mv;
	}

	@GetMapping("/reserva")
	public String reserva(HttpSession session) {
		if(Objects.isNull(session.getAttribute("user"))) {
			session.setAttribute("authError", "Entre para reservar um laboratório");
			return "redirect:/home";
		}else {
			return "Reserva";
		}
	}
	
}