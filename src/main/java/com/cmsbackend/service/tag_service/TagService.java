package com.cmsbackend.service.tag_service;

import com.cmsbackend.entity.tags_entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface TagService {
    Tag getById(long id);
    List<Tag> getByType(int type);
}
