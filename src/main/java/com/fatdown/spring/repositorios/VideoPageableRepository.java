package com.fatdown.spring.repositorios;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fatdown.spring.entidades.Video;

@Repository
@Component("videoPageableRepository")
public interface VideoPageableRepository extends  PagingAndSortingRepository<Video, Long> {

	Page<Video> findAll(Pageable p);

}
