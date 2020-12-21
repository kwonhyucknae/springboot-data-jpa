package com.springboot.jpa.jpatest;

import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Setter
public class DogHomeAddress {
    private String street;
    private String city;
}
