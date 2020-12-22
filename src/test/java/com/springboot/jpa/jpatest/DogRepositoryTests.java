package com.springboot.jpa.jpatest;

import com.springboot.jpa.jpatest.model.Cat;
import com.springboot.jpa.jpatest.model.Dog;
import com.springboot.jpa.jpatest.model.DogHomeAddress;
import com.springboot.jpa.jpatest.repository.DogRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
class DogRepositoryTests {

    @Autowired
    DogRepository dogRepository;

    @Test
    @Rollback(false)
    void contextLoads() {
        // Given
        Dog dog = new Dog();
        DogHomeAddress dogHomeAddress = new DogHomeAddress();

        dogHomeAddress.setCity("test");
        dog.setDogName("DogTest");
        dog.setDogHomeAddress(dogHomeAddress);

        Cat cat = new Cat();
        cat.setCatName("cats123");

        // When
        dogRepository.save(dog);

        // Then
        assertThat(dog.getId()).isNotNull();
    }
}
