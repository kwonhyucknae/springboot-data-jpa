package com.springboot.jpa.jpatest;

import com.springboot.jpa.jpatest.model.Cat;
import com.springboot.jpa.jpatest.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class CatRepositoryTests {

    @Autowired
    CatRepository catRepository;

    @Test
    @Rollback(false)
    void contextLoads() {
        // Given
        Cat cat = new Cat();
        cat.setCatName("cats123");

        // When
        catRepository.save(cat);

        // Then
        assertThat(cat.getId()).isNotNull();
    }

    @Test
    @Rollback(false)
    void catCustomQuery() {
        // When
        List<Cat> catList = catRepository.findCatCustomQuery("cats123");

        // Then
        assertThat(catList).isNotNull();
    }
}
