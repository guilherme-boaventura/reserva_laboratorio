package br.ucsal.reserva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.ucsal.reserva.service.ProfessorService;

@Controller
public class ProfessorController {
	
	@Autowired
	ProfessorService service;

	@PostMapping("/cadastrarProfessor")
	public String cadastrarProfessor(@RequestParam(name="nome") String nome,
									 @RequestParam(name="email") String email,
									 @RequestParam(name="login") String login,
									 @RequestParam(name="senha") String senha,
									 @RequestParam(name="disciplina") String disciplina,
									 @RequestParam(name="admin", required=false) boolean admin) { 
		service.cadastrar(nome,email,login,senha,disciplina,(admin == true) ? admin : false);
		return "redirect:/cadastroProfessor";
	}
	
}