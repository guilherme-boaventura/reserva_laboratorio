package br.ucsal.reserva.controller;

import java.text.SimpleDateFormat;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ucsal.reserva.model.Disciplina;
import br.ucsal.reserva.service.LaboratorioService;
import br.ucsal.reserva.service.ReservaService;
import jakarta.servlet.http.HttpSession;

@Controller
public class PathController {

	@Autowired
	private ReservaService reservaService;
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public ModelAndView inicio(HttpSession session) {
		ModelAndView mv = new ModelAndView("Index");
		mv.addObject("reservas", reservaService.getAprovadas());
		mv.addObject("user", session.getAttribute("user"));
		mv.addObject("authError", session.getAttribute("authError"));
		return mv;
	}

	@GetMapping("/reserva")
	public Object reserva(HttpSession session) {
		if(Objects.isNull(session.getAttribute("user"))) {
			ModelAndView mv = new ModelAndView("Index");
			session.setAttribute("authError", "Entre para reservar um laboratório");
			return "redirect:/home";
		}else {
			ModelAndView mv = new ModelAndView("Reserva");
			mv.addObject("disciplinas", Disciplina.getAll());
			mv.addObject("laboratorios", laboratorioService.getAll());
			return mv;
		}
	}
	
}