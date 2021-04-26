package com.fatdown.spring.controladores;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatdown.spring.entidades.Usuario;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioControlador {
	//TODO 	
	// Falta hacer el servicio y su implementación. ¿Cómo se hacía con un repositorio en vez de un DAO?
//	@Autowired
//	private UsuarioServicio usuarioServicio;
}
