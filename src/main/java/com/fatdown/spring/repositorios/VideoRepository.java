package com.fatdown.spring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fatdown.spring.entidades.Video;

@Repository
@Component("videoRepository")
public interface VideoRepository extends CrudRepository<Video, Long> {

}
