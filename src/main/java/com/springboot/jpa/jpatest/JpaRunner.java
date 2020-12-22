package com.springboot.jpa.jpatest;

import com.springboot.jpa.jpatest.model.Cat;
import com.springboot.jpa.jpatest.model.CatHome;
import com.springboot.jpa.jpatest.model.Dog;
import com.springboot.jpa.jpatest.model.DogHomeAddress;
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
//        embeddedTest();
        relationTest();
    }

    private void embeddedTest() {
        Dog dog = new Dog();
        DogHomeAddress dogHomeAddress = new DogHomeAddress();

        dogHomeAddress.setCity("test");
        dog.setDogName("DogTest");
        dog.setDogHomeAddress(dogHomeAddress);

        entityManager.persist(dog);
    }

    private void relationTest() {

        CatHome catHome = new CatHome();
        catHome.setCatHomeName("BigHome");

        Cat cat = new Cat();
        cat.setCatName("cats");
        cat.setCatHome(catHome);

        catHome.getCats().add(cat);

        entityManager.persist(catHome);
        entityManager.persist(cat);

        cat.setCatName("cat123");
        cat.setCatName("cats");
        entityManager.find(Cat.class, cat.getId());
    }
}
