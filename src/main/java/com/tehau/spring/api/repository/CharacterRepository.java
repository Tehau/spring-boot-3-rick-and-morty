package com.tehau.spring.api.repository;

import com.tehau.spring.api.model.CharacterRM;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class CharacterRepository implements JpaRepository<CharacterRM, Long> {

    @Override
    public void flush() {

    }

    @Override
    public <S extends CharacterRM> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends CharacterRM> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<CharacterRM> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CharacterRM getOne(Long aLong) {
        return null;
    }

    @Override
    public CharacterRM getById(Long aLong) {
        return null;
    }

    @Override
    public CharacterRM getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends CharacterRM> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CharacterRM> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CharacterRM> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CharacterRM> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CharacterRM> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CharacterRM> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends CharacterRM, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends CharacterRM> S save(S entity) {
        return null;
    }

    @Override
    public <S extends CharacterRM> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CharacterRM> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<CharacterRM> findAll() {
        return null;
    }

    @Override
    public List<CharacterRM> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CharacterRM entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends CharacterRM> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<CharacterRM> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CharacterRM> findAll(Pageable pageable) {
        return null;
    }
}
