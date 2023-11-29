package com.cmsbackend.dao.tag_dao;

import com.cmsbackend.entity.tags_entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
public interface TagDao extends JpaRepository<Tag, Long>, Serializable {

    List<Tag> getByType(int type);

    Tag getById(long id);
}
