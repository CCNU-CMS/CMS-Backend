package com.cmsbackend.entity.comment_entity;
import com.cmsbackend.entity.user_entity.User;
import lombok.Data;

import javax.persistence.*;
@Data
@Table(name = "comments")
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long postId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(length = 1000)
    private String content;

    @Column(length = 20)
    private String commentDate;

    @Column
    private long parentCommentId;
}
