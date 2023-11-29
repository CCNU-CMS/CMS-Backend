package com.cmsbackend.entity.user_course_entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_course")
public class UserCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "user_id")
    private Long userId;


    @Column(name = "identity")
    private Long identity;
}
