package com.fatdown.spring.seguridad;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fatdown.spring.entidades.Ejercicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.fatdown.spring.entidades.Usuario;
import com.fatdown.spring.servicios.UsuarioServicio;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private UsuarioServicio usuarioServicio;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	private final int VALORPORDEFECTO = 5;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		HttpSession session = request.getSession();
		// El UserDetails busca por username. ¿En login debe ser el name=username aunque sea emailUsuario para que lo encuentre?
		Usuario authUser = usuarioServicio.buscarPorEmailUsuario(userDetails.getUsername());
		Set<Ejercicio> crearRutina = new HashSet<>();
		session.setAttribute("nombre", authUser.getNombreUsuario());
		session.setAttribute("idUsuario", authUser.getIdUsuario());
		session.setAttribute("tuRutina", crearRutina);

		boolean esRegistrado = false;
		boolean esAdmin = false;
		final Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("registrado")) {
				esRegistrado = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("admin")) {
				esAdmin = true;
				break;
			}
		}

		String targetUrl;
		if (esRegistrado) {
			targetUrl = "/usuario/userid/" + authUser.getIdUsuario();
		} else if (esAdmin) {
			targetUrl = "/index";
		} else {
			throw new IllegalStateException();
		}

		Cookie cookie = new Cookie("idUsuario", authUser.getIdUsuario().toString());
		response.addCookie(cookie);

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public void setRedirectStrategy(final RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}