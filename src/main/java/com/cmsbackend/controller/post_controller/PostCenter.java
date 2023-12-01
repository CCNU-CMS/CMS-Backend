package com.cmsbackend.controller.post_controller;

import com.cmsbackend.controller.post_controller.post_vo.AddRequest;
import com.cmsbackend.entity.posts_entity.Post;
import com.cmsbackend.entity.user_entity.User;
import com.cmsbackend.entity.tags_entity.Tag;
import com.cmsbackend.service.post_service.PostService;
import com.cmsbackend.service.post_tag_service.PostTagService;
import com.cmsbackend.service.user_service.UserService;
import com.cmsbackend.service.tag_service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import java.util.List;
import org.springframework.data.domain.Page;
@Slf4j
@RestController
@RequestMapping("/post")
@Api(tags = "Post Controller")
public class PostCenter {

    private final TagService tagService;
    private final PostService postService;
    private final UserService userService;
    private final PostTagService postTagService;

    public PostCenter(PostService postService, UserService userService, TagService tagService,PostTagService postTagService)
    {
        this.postService = postService;
        this.userService = userService;
        this.tagService = tagService;
        this.postTagService = postTagService;
    }

    @PostMapping(value ="/add", headers = "Content-Type=application/json", produces = "application/json")
    @ApiOperation("新增帖子")
    public ResponseEntity<String> addPost(@RequestBody AddRequest addRequest) {
        // 这里可以处理添加新帖子的逻辑，使用 postRequest 中的属性
         //postRequest.getId(), postRequest.getContent(), postRequest.getCreated_at(), postRequest.getTags()
        //  设置post属性
        Post post = new Post();
        post.setContent(addRequest.getContent());
        post.setCreatedAt(LocalDateTime.now());
        //post.setCreatedAt(addRequest.getCreated_at());
        List<Long> tagIds = addRequest.getTag_id();//获取tag_id
        // 创建一个空的 tags 集合
        Set<Tag> tags = new HashSet<>();
        // 遍历 tagIds，根据每个 tagId 查询相应的 Tag 对象，并添加到 tags 中
        for (Long tagId : tagIds) {
            Tag tag = tagService.getById(tagId);
            if (tag != null) {
                tags.add(tag);
            }
        }
        post.setTags(tags);//setTags
        String account = addRequest.getAccount();//获取用户account
        User user = userService.getUserByAccount(account);//获取用户信息
        post.setUser(user);
        try{
            postService.save(post);
            return new ResponseEntity<>("Post added successfully", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            log.error("Failed to create post",e);
            throw new RuntimeException("Failed to create post", e);
        }
    }

    @ApiOperation("获取全部帖子")
    @GetMapping(value = "/getAllPosts/{page}")
    public Page<Post> getAllPosts(@PathVariable("page") Integer page)
    {
        log.info("Fetching all posts");
        return postService.findAll(page - 1, 15);
    }

    @ApiOperation("获取帖子信息")
    @GetMapping(value = "/getPost/{postId}")
    public Post getPostInfo(@PathVariable long postId)
    {
        log.info("Fetching info for post: {}", postId);
        return postService.findPostById(postId);
    }

    @ApiOperation("获取用户全部帖子")
    @GetMapping(value = "/getUserPosts/{userId}")
    public List<Post> getPostsByUserId(@PathVariable long userId)
    {
        log.info("Fetching all posts of user:{}",userId);
        return postService.findPostByUserId(userId);
    }

    //需要在一个事务中进行
    @Transactional
    @ApiOperation("删除帖子")
    @DeleteMapping(value = "/delete/{postId}")
    public String deletePost(@PathVariable long postId)
    {
        log.info("Deleting course: {}", postId);
        try{
            postTagService.deletePostTag(postId);//删除关联表中的post相关行
            //postTagService.deleteByPostId(postId);
            postService.deleteById(postId);//删除post表中的帖子
            return "删除帖子成功!";
        }
        catch (Exception e)
        {
            log.error("Failed to delete post", e);
            throw new RuntimeException("Failed to delete post", e);
        }
    }

}
