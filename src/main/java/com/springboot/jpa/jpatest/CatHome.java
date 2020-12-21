package com.springboot.jpa.jpatest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
public class CatHome {
    @Id @GeneratedValue
    private Long id;

    private String CatHomeName;

    @OneToMany(mappedBy = "catHome")
    private Set<Cat> cats = new HashSet<>();
}
