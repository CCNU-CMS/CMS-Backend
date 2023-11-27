package com.cmsbackend.controller.user_controller;

import com.cmsbackend.controller.user_controller.user_vo.*;
import com.cmsbackend.entity.user_entity.User;
import com.cmsbackend.service.user_service.UserService;
import com.cmsbackend.utils.JWT.JwtTokenUtil;
import com.cmsbackend.utils.hash.Hash;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        int identity;
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

    @ApiOperation("删除用户信息")
    @DeleteMapping(value = "/admin")
    @Transactional
    public String Info(@RequestParam("code") String code, @RequestAttribute("account") String account) {
        try {
            userService.deleteUserByAccount(account);
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
        InfoResp resp = new InfoResp(user.getId(), user.getName(),user.getSex(),user.getAccount(),user.getDept(),user.getIdentity());
        return resp;
    }



    @ApiOperation("错误")
    @GetMapping(value = "/error")
    public void error(){
        System.out.println("hello world");
        throw new RuntimeException("自定义异常");
    }


}