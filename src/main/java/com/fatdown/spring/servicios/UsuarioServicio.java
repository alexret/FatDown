package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Usuario;

import javax.servlet.http.HttpServletRequest;

public interface UsuarioServicio {

	Usuario crearUsuario(Usuario usuario, HttpServletRequest request);
	
	void eliminarUsuario(long idUsuario);

	Usuario obtenerUsuario(long idUsuario);
	
	Usuario modificarUsuario(Usuario usuario);

	Iterable<Usuario> listarUsuarios();
	
	//public Usuario buscarPorNombreUsuario(String username);
	
	Usuario buscarPorEmailUsuario(String emailUsuario);

}
