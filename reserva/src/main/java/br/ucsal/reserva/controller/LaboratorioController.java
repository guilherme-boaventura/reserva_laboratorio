package br.ucsal.reserva.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

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

	@GetMapping
	public String listarLaboratorios(Model model) {
		List<Laboratorio> laboratorios = laboratorioService.listarTodos();
		model.addAttribute("laboratorios", laboratorios);
		return "laboratorios";
	}

	@PostMapping()
	public String createLab(@RequestParam("descricao") String descricao, @RequestParam("numMaquinas") int numMaquinas,
			@RequestParam("localizacao") String localizacao) {
		laboratorioService.cadastrar(descricao, numMaquinas, localizacao);
		return "redirect:/laboratorios";

	}

}
