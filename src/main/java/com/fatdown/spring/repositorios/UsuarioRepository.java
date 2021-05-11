package com.fatdown.spring.repositorios;

import java.util.List;
import java.util.Optional;

import com.fatdown.spring.servicios.UsuarioServicio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fatdown.spring.entidades.Usuario;

@Repository
@Component("usuarioRepository")
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	//Usuario findByUsername(String username);
//	Usuario findByEmailUsuario(String emailUsuario);


	@Query(value = "select u.* from Usuario u where email_usuario= :emailUsuario", nativeQuery = true)
	Usuario findByEmailUsuario(String emailUsuario);
}
