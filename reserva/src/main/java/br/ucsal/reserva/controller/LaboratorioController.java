package br.ucsal.reserva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ucsal.reserva.model.Laboratorio;
import br.ucsal.reserva.service.LaboratorioService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/laboratorios")
public class LaboratorioController {

	@Autowired
	private final LaboratorioService laboratorioService;

	public LaboratorioController(LaboratorioService laboratorioService) {
		this.laboratorioService = laboratorioService;
	}

	@PostMapping()
	public String createLab(@RequestParam("descricao") String descricao, 
			@RequestParam("numMaquinas") int numMaquinas,
			@RequestParam("localizacao") String localizacao,
			HttpSession session) {
		Object retorno = laboratorioService.cadastrar(descricao, numMaquinas, localizacao);
		
		if(!(retorno instanceof Laboratorio)) {
			session.setAttribute("error", retorno);
			return "redirect:/laboratorios";
		}
		
		session.removeAttribute("error");
		return "redirect:/laboratorios";

	}

}
