package com.cmsbackend.controller.tag_controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import com.cmsbackend.entity.tags_entity.Tag;
import com.cmsbackend.service.tag_service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tag")
@Api(tags = "Tag Controller")
public class TagCenter {

    private final TagService tagService;

    public TagCenter (TagService tagService)
    {
        this.tagService = tagService;
    }

    @ApiOperation("获取帖子标签")
    @GetMapping(value = "/getTags/{type}")
    public List<Tag> getByType(@PathVariable int type)
    {
        try{
            log.info("get tags :{}", type);
            return tagService.getByType(type);
        }
        catch(Exception e)
        {
            log.error("Failed to get tags", e);
            throw new RuntimeException("Failed to get tags", e);
        }
    }

}
