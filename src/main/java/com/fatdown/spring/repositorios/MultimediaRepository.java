package com.fatdown.spring.repositorios;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fatdown.spring.entidades.Multimedia;

@Repository
@Component("multimediaRepository")
public interface MultimediaRepository extends PagingAndSortingRepository<Multimedia, Long> {

}
