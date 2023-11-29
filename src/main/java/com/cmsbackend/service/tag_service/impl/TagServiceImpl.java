package com.cmsbackend.service.tag_service.impl;

import com.cmsbackend.dao.tag_dao.TagDao;
import com.cmsbackend.service.tag_service.TagService;
import com.cmsbackend.entity.tags_entity.Tag;
import java.util.List;
public class TagServiceImpl implements TagService {

    private final TagDao tagDao;
    public TagServiceImpl (TagDao tagDao){
        this.tagDao = tagDao;
    }

    @Override
    public Tag getById(long id){
        Tag tag = tagDao.getById(id);
        return tag;
    }

    @Override
    public List<Tag> getByType(int type)
    {
        List<Tag> tags = tagDao.getByType(type);
        return  tags;
    }
}
