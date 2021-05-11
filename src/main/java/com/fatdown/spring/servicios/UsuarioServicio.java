package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Usuario;

public interface UsuarioServicio {

	Usuario crearUsuario(Usuario usuario);
	
	void eliminarUsuario(long idUsuario);

	Usuario obtenerUsuario(long idUsuario);
	
	Usuario modificarUsuario(Usuario usuario);

	Iterable<Usuario> listarUsuarios();
	
	//public Usuario buscarPorNombreUsuario(String username);
	
	Usuario buscarPorEmailUsuario(String emailUsuario);

}
