package com.crud.tasks.domain;


import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="tasks")
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name="name")
    private String title;
    @Column(name="description")
    private String content;
}
