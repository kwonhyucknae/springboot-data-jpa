package com.springboot.jpa.jpatest.model;

import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
public class DogHomeAddress {
    private String street;
    private String city;
}
