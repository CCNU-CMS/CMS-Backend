package com.cmsbackend.controller.user_controller.user_vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
//@ApiModel
public class InfoResp {

    private Long id;

    private String name;

    private String account;

    private String sex;

    private String dept;

    private Integer identity;


    public InfoResp(Long id, String name, String account, String sex,
                    String dept, Integer identity){
        this.id=id;
        this.name = name;
        this.account =account;
        this.sex = sex;
        this.dept = dept;
        this.identity = identity;
    }

}
