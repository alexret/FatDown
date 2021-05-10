package com.fatdown.spring.servicios;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fatdown.spring.entidades.Rol;
import com.fatdown.spring.entidades.Usuario;
import com.fatdown.spring.repositorios.RolRepository;
import com.fatdown.spring.repositorios.UsuarioRepository;

@Transactional
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private RolRepository rolRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

//	@PersistenceContext
//	protected EntityManager em;

	public UsuarioServicioImpl() {
		super();
	}

	public UsuarioServicioImpl(UsuarioRepository usuarioRepository, RolRepository rolRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.rolRepository = rolRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		usuario.setPasswordUsuario(bCryptPasswordEncoder.encode(usuario.getPasswordUsuario()));
		Rol r = rolRepository.findById(2).orElse(null);
		usuario.anadirRol(r);
		return usuarioRepository.save(usuario);
	}

	@Override
	public void eliminarUsuario(long idUsuario) {
		usuarioRepository.deleteById(idUsuario);

	}

	@Override
	public Usuario obtenerUsuario(long idUsuario) {
		return usuarioRepository.findById(idUsuario).orElse(null);
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Iterable<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario buscarPorEmailUsuario(String emailUsuario) {
		return usuarioRepository.findByEmailUsuario(emailUsuario);
	}
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // or any other password encoder
    }

//	@Override
//	public Usuario buscarPorEmailUsuario(String emailUsuario) {
//		Query query = this.em.createQuery("select u FROM Usuario u where u.emailUsuario =  :emailUsuario");
//		query.setParameter("emailUsuario", emailUsuario);
//
//		try {
//			Usuario usuario = (Usuario) query.getSingleResult();
//			return usuario;
//		} catch (javax.persistence.NoResultException e) {
//			return null;
//		}
//
//	}
}
