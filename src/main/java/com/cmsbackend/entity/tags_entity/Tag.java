package com.cmsbackend.entity.tags_entity;
import lombok.Data;
import javax.persistence.*;
@Data
@Table(name = "tags")
@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column
    private int type;//0:课程 1:专业
}
