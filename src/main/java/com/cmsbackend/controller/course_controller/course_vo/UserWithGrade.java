package com.cmsbackend.controller.course_controller.course_vo;

import com.cmsbackend.entity.user_entity.User;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class UserWithGrade {
    private User user;
    private Float grade;

    public UserWithGrade(User user, Float grade) {
        this.user = user;
        this.grade = grade;
    }

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}