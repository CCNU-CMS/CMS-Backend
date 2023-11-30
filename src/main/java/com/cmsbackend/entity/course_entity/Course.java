package com.cmsbackend.entity.course_entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "courses")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    @Column(length = 255)
    private String teacher;

}
