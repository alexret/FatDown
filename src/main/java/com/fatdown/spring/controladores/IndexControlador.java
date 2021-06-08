package com.fatdown.spring.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.fatdown.spring.entidades.Consejo;
import com.fatdown.spring.servicios.ConsejoServicio;

@Controller
public class IndexControlador {

	@Autowired
	ConsejoServicio consejoServicio;

	@GetMapping({ "/", "index" })
	public String index(Model model, HttpSession session) {

		List<Consejo> consejos = (List<Consejo>) consejoServicio.listarConsejo();

		model.addAttribute("consejos", consejos);

		return "index";
	}

	@PostMapping("/volver")
	public String volverAlInicio(HttpServletRequest request) {
		return "redirect:/index";
	}
}
