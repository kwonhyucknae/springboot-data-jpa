package com.springboot.jpa.jpatest;

import com.springboot.jpa.jpatest.model.Cat;
import com.springboot.jpa.jpatest.model.Dog;
import com.springboot.jpa.jpatest.model.DogHomeAddress;
import com.springboot.jpa.jpatest.repository.CatRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class JpaStateTests {

    @Autowired
    CatRepository catRepository;

    @Test
    @Rollback(false)
    void dirtyCheckTest() {
        // Given
        Cat cat = new Cat();
        cat.setCatName("cats123");

        // When
        catRepository.save(cat);
        cat.setCatName("cats1234");
        cat.setCatName("cats123");

        catRepository.findAllByCatName(cat.getCatName());
        // Then
        assertThat(cat.getId()).isNotNull();
    }
}
