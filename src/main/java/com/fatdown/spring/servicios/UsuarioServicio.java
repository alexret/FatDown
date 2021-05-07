package com.fatdown.spring.servicios;

import com.fatdown.spring.entidades.Usuario;

public interface UsuarioServicio {

	public Usuario crearUsuario(Usuario usuario);
	
	public void eliminarUsuario (long idUsuario);

	public Usuario obtenerUsuario(long idUsuario);
	
	public Usuario modificarUsuario(Usuario usuario);

	public Iterable<Usuario> listarUsuarios();
	
	public Usuario buscarPorNombreUsuario(String username);
	
	public Usuario buscarPorEmailUsuario (String emailUsuario);

}
