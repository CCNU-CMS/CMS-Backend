package com.cmsbackend.entity.posts_entity;
import com.cmsbackend.entity.tags_entity.Tag;
import com.cmsbackend.entity.user_entity.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.Date;
import javax.persistence.*;

@Data
@Table(name = "posts")
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String content;

    @Column(name = "created_at", nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    标签和帖子的多对多关系
    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id",referencedColumnName = "id"),
            inverseJoinColumns = {@JoinColumn(name = "tag_id",referencedColumnName = "id")})
    private Set<Tag> tags;
}
