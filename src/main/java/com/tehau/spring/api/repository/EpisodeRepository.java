package com.tehau.spring.api.repository;

import com.tehau.spring.api.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EpisodeRepository  extends JpaRepository<Episode, Long> {
   List<Episode> findAll();

    Optional<Episode> findById(Long id);

    Episode save(Episode entity);



}
