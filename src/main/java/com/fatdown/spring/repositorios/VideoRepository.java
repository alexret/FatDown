package com.fatdown.spring.repositorios;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("videoRepository")
public interface VideoRepository extends MultimediaRepository {

}
