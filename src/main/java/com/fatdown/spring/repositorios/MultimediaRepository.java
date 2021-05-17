package com.fatdown.spring.repositorios;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.fatdown.spring.entidades.Multimedia;

@NoRepositoryBean
//Hace que no se pueda instanciar, para que se herede
@Component("multimediaRepository")
public interface MultimediaRepository extends PagingAndSortingRepository<Multimedia, Long> {

}
