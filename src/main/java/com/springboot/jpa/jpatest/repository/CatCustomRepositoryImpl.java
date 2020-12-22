package com.springboot.jpa.jpatest.repository;

import com.springboot.jpa.jpatest.model.Cat;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class CatCustomRepositoryImpl implements CatCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cat> findCatCustomQuery(String param) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cat> query = criteriaBuilder.createQuery(Cat.class);
        Root<Cat> catRoot = query.from(Cat.class);

        Path<String> catNamePath = catRoot.get("catName");

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(catNamePath, param));

        query.select(catRoot)
                .where(criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                .getResultList();
    }
}
