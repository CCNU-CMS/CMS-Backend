package com.cmsbackend.controller.user_controller;

import com.cmsbackend.controller.user_controller.user_vo.*;
import com.cmsbackend.entity.user_course_entity.UserCourse;
import com.cmsbackend.entity.user_entity.User;
import com.cmsbackend.service.user_service.UserService;
import com.cmsbackend.utils.JWT.JwtTokenUtil;
import com.cmsbackend.utils.hash.Hash;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(tags = "用户接口")
@CrossOrigin(origins = "*")
public class UserCenter {
    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;

    public UserCenter(UserService userService, JwtTokenUtil jwtTokenUtil){
        this.userService = userService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @ApiOperation("新增用户")
    @PostMapping(value = "/admin/add", headers = "Content-Type=application/json", produces = "application/json")
    public Map<String,Object> Register(@RequestBody AddRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        User user = userService.getUserByAccount(request.getAccount());
        if (user!=null){
            throw new RuntimeException("用户已注册");
        }

        User user1 = new User();
        String hash_pwd = Hash.encoder(request.getPassword());
        user1.setPassword(hash_pwd);
        user1.setIdentity(request.getIdentity());
        user1.setName(request.getName());
        user1.setAccount(request.getAccount());

        long result =userService.save(user1);

        String token= jwtTokenUtil.generateToken(request.getAccount());
        resultMap.put("user-id",result);
        resultMap.put("token",token);
        return resultMap;
    }

    @ApiOperation("用户登录")
    @PostMapping(value = "/login")
    public  Map<String,Object> Login(@RequestBody LoginRequest request){
        System.out.println(request);
        String token = null;
        System.out.println(request);
        Long identity;
        Map<String, Object> resultMap = new HashMap<>();
        User user = userService.getUserByAccount(request.getAccount());

        System.out.println(user);

        if (Hash.match(request.getPassword(),user.getPassword())){
            token= jwtTokenUtil.generateToken(request.getAccount());
            System.out.println(token);
            identity = userService.getIdentity(request.getAccount());
            resultMap.put("token",token);
            resultMap.put("identity",identity);
        }else {
            throw new RuntimeException("密码错误");
        }

        return resultMap;
    }


    @ApiOperation("修改密码")
    @PutMapping(value = "/password")
    public String UpdatePassword(@RequestBody UpdatePswRequest request, @RequestAttribute("account") String account){

        User user = userService.getUserByAccount(account);
        if (Hash.match(request.getOldPassword(),user.getPassword())){
            user.setPassword(Hash.encoder(request.getNewPassword()));
            try {
                userService.save(user);
                return "修改密码成功";
            }catch (Exception e){
                throw new RuntimeException("修改失败");
            }
        }
        throw new RuntimeException("原始密码错误");
    }

    @ApiOperation("修改用户信息")
    @PutMapping(value = "/info")
    public String UpdateInfo(@RequestBody UpdateInfoRequest request, @RequestAttribute("account") String account){

        User user = userService.getUserByAccount(account);

        user.setAccount(request.getAccount());
        user.setName(request.getName());
        user.setDept(request.getDept());
        user.setSex(request.getSex());
        try {
            userService.save(user);
            return "修改成功";
        }catch (Exception e)
        {
            throw new RuntimeException("Failed to update info",e);
        }
    }

    @ApiOperation("删除用户信息")
    @DeleteMapping(value = "/admin")
    @Transactional
    public String DeleteInfo(@RequestParam("account") String account0,@RequestAttribute("account") String account) {

        User user = userService.getUserByAccount(account);

        if (user.getIdentity()<2){
            throw new RuntimeException("权限不足,非管理员无法删除用户");
       }

        try {
            userService.deleteUserByAccount(account0);
            return "删除用户成功";
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常堆栈信息
            throw new RuntimeException("删除失败");
        }

    }



    @ApiOperation("用户信息")
    @GetMapping(value = "/info")
    public InfoResp Info(@RequestAttribute("account") String account){
        System.out.println("account");
        System.out.println(account);
        User user = userService.getUserByAccount(account);

        InfoResp resp = new InfoResp(user.getId(), user.getName(),user.getAccount(),user.getSex(),user.getDept(),user.getIdentity());
        return resp;
    }

    @ApiOperation("查看所有用户")
    @GetMapping("/all")
    public Map<String, Object>  GetAllPeople(@RequestParam("page") Integer page, @RequestParam("identity") Integer identity,@RequestAttribute("account") String account) {
//        @RequestParam("identity") Integer identity
        User u0 = userService.getUserByAccount(account);
        if (u0.getIdentity() < 2) {
            throw new RuntimeException("权限不足");
        }
        System.out.println(u0.getId() + "testing");
        if (identity != -1) {
            List<User> us = userService.getUserByIdentity(identity,page - 1, 10);
            Map<String, Object> response = new HashMap<>();
            response.put("size", us.size());
            response.put("users", us);
            return response;
        } else {
            Page<User> us = userService.getUser(page - 1, 10);
            Map<String, Object> response = new HashMap<>();
            response.put("size", us.getTotalElements());
            response.put("users", us);
            return response;
        }
    }

    @ApiOperation("错误")
    @GetMapping(value = "/error")
    public void error(){
        System.out.println("hello world");
        throw new RuntimeException("自定义异常");
    }


}
