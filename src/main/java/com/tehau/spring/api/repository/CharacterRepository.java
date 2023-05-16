package com.tehau.spring.api.repository;

import com.tehau.spring.api.model.CharacterRM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<CharacterRM, Long> {

    @Override
    List<CharacterRM> findAll();
}
