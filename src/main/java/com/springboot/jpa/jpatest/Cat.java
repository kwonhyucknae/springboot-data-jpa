package com.springboot.jpa.jpatest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
public class Cat {

    @Id @GeneratedValue
    private Long id;

    private String catName;

    @ManyToOne
    private CatHome catHome;

}
