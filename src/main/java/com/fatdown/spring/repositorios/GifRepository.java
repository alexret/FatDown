package com.fatdown.spring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fatdown.spring.entidades.Gif;

@Repository
@Component("gifRepository")
public interface GifRepository extends CrudRepository<Gif, Long> {

}
