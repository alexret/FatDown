package com.fatdown.spring.controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatdown.spring.servicios.UsuarioServicio;
import com.fatdown.spring.entidades.Usuario;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioControlador {
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	// Métodos get y post

	@GetMapping("/signup")
	public String signup(Model model, HttpSession session) {
		return "signup";
	}

	@PostMapping("/signup")
	public String darseDeAlta(Usuario usuario, HttpServletRequest request) {

		usuarioServicio.crearUsuario(usuario, request);

		return "redirect:/index";
	}

	@GetMapping("/login")
	public String login(Model model, HttpSession session) {

		return "login";
	}

	@GetMapping("/login_error")
	public String login_error(Model model, HttpSession session) {

		return "login_error";
	}

//	@PostMapping("/login")
//	public String iniciarSesion(Model model, HttpServletRequest request, HttpSession session) {
//
//		// Recogemos los valores del formulario
//		String emailUsuario = request.getParameter("username");
//		String passwordUsuario = request.getParameter("password");
//
//		Usuario buscado = usuarioServicio.buscarPorEmailUsuario(emailUsuario);
//		// Solución provisional al problema con security. No descifra bien las contraseñas.
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		// Comprobamos si el email y el password son correctos buscando el usuario
//		if ((buscado != null)) {
//			if (encoder.matches(passwordUsuario, buscado.getPasswordUsuario())) {
//			//if (buscado.getPasswordUsuario().equals(passwordUsuario)) {
//				session.setAttribute("usuario", buscado);
//				return "redirect:/index";
//			}
//		}
//
//		return "login_error";
//
//	}

	@PostMapping("/logout")
	public String cerrarSesion(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/index";
	}

	@GetMapping("/userid/{idUsuario}")
	public String usuarioid(Model model, HttpSession session, @PathVariable("idUsuario") long idUsuario) {
		// Se recoge el input de la búsqueda de la session
		// y se usa el servicio para buscar en la tabla
		Usuario resultadoURL = usuarioServicio.obtenerUsuario(idUsuario);
		model.addAttribute("usuario", resultadoURL);

		long idUsuarioSESSION = (long) session.getAttribute("idUsuario");
		model.addAttribute("idUsuarioSESSION", idUsuarioSESSION);

		return "userid";
	}
}
