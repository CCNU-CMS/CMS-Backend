package com.cmsbackend.controller.course_controller.course_vo;

import com.cmsbackend.entity.course_entity.Course;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel
public class CourseWithGrade {
    private Course course;
    private Float grade;

    public CourseWithGrade(Course course, Float grade) {
        this.course = course;
        this.grade = grade;
    }

    // Getters and Setters
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}
