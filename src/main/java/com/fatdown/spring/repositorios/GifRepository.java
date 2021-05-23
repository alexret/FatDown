package com.fatdown.spring.repositorios;

import com.fatdown.spring.entidades.Gif;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("gifRepository")
public interface GifRepository extends CrudRepository<Gif, Long> {

}
