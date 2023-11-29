package com.cmsbackend.service.post_tag_service;

import com.cmsbackend.entity.posts_entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
public interface PostTagService extends JpaRepository<Post, Long> {
    //直接使用原生SQL语句进行关联表的删除
    @Modifying
    @Query(value = "DELETE FROM post_tags WHERE post_id = :postId", nativeQuery = true)
    void deletePostTag(@Param("postId") Long postId);
}
