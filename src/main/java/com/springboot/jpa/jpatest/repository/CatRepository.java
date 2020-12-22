package com.springboot.jpa.jpatest.repository;

import com.springboot.jpa.jpatest.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long>, CatCustomRepository {
    List<Cat> findAllByCatName(String catName);
}
