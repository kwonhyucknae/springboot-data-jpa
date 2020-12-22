package com.springboot.jpa.jpatest.repository;

import com.springboot.jpa.jpatest.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
