package com.fatdown.spring.controladores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControlador {
	@GetMapping({ "/", "index" })
	public String index(Model model, HttpSession session) {
		return "index";
	}
	
	@PostMapping("/volver")
	public String volverAlInicio(HttpServletRequest request) {
		return "redirect:/index";
	}
}
