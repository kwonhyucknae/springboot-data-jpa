package com.springboot.jpa.jpatest;

import javax.persistence.Embeddable;

@Embeddable
public class DogHomeAddress {
    private String street;
    private String city;
}
