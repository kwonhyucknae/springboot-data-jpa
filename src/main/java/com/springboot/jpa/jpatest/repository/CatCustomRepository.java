package com.springboot.jpa.jpatest.repository;

import com.springboot.jpa.jpatest.model.Cat;

import java.util.List;

public interface CatCustomRepository {
    List<Cat> findCatCustomQuery(String param);
}
