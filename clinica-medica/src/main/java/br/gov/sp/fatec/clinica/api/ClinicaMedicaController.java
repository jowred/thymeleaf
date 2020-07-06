package br.gov.sp.fatec.clinica.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import br.gov.sp.fatec.clinica.model.ClinicaMedica;
import br.gov.sp.fatec.clinica.service.ClinicaMedicaService;

@Controller
public class ClinicaMedicaController {
	
	@Autowired
	private ClinicaMedicaService service;

	@GetMapping("/new")
	public String initialize(Model model) {
		model.addAttribute("clinica", new ClinicaMedica());
		model.addAttribute("clinicas", service.findAll());
		return "form";
	}

	@PostMapping("/new")
	public String save(@ModelAttribute ClinicaMedica clinica, Model model) {
		model.addAttribute("clinica", clinica);
//		System.out.printf("Clínica Médica: %s", clinica);
		service.saveOrUpdate(clinica);
		return "salvo";
	}
	
	@GetMapping("/clinicas")
	public String getAll(Model model) {
		model.addAttribute("filtro", new ClinicaMedica());
		model.addAttribute("clinicas", service.findAll());
		return "pesquisa";
	}
	
	@GetMapping("/clinicas/filtro")
	public String filtrar(@ModelAttribute ClinicaMedica clinica, Model model) {
		model.addAttribute("filtro", new ClinicaMedica());
		model.addAttribute("clinicas", service.findByNomeLikeAndNomeConvenioLikeAndNomeMedicoLike(clinica));
		return "pesquisa";
	}
	
}
