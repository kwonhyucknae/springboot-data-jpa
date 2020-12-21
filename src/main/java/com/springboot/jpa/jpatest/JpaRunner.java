package com.springboot.jpa.jpatest;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Dog dog = new Dog();
        DogHomeAddress dogHomeAddress = new DogHomeAddress();

        dogHomeAddress.setCity("test");
        dog.setDogName("DogTest");
        dog.setDogHomeAddress(dogHomeAddress);
        
        entityManager.persist(dog);
    }
}