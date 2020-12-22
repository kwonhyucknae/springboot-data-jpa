package com.springboot.jpa.jpatest.repository;

import com.springboot.jpa.jpatest.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findAllByDogName(String dogName);

    @Query("select dog from Dog dog where dog.dogName = :dogNameParam ")
    List<Dog> findDogByCustomQuery(@Param("dogNameParam") String dogNameParam);
}
