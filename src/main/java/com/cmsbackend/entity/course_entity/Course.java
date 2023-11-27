package com.cmsbackend.entity.course_entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "courses")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 30)
    private String time;

    @Column(length = 20)
    private String classroom;

    @Column(length = 20)
    private String dept;

    @Column(length = 255)
    private String description;

}
