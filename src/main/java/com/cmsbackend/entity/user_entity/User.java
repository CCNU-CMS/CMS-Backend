package com.cmsbackend.entity.user_entity;

import lombok.Data;
import org.springframework.data.redis.connection.stream.StreamInfo;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 30)
    private String account;

    @Column(length = 20)
    private String password;

    @Column(length = 20)
    private String sex;

    @Column(length = 20)
    private String dept;

//    @Column(length = 500)
//    private String avatar;

    @Column
    private Long identity;
}