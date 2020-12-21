package com.springboot.jpa.jpatest;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Dog {
    @Id @GeneratedValue
    private Long id;

    private String dogName;

    @Transient
    private String exceptField;

    @Embedded
    private DogHomeAddress dogHomeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column("house_street"))
    })
    private DogHomeAddress difDogHomeAddress;

}
