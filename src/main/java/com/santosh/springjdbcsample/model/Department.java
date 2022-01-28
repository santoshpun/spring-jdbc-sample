package com.santosh.springjdbcsample.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private int id;
    private String name;

    public Department(int id) {
        this.id = id;
    }
}
