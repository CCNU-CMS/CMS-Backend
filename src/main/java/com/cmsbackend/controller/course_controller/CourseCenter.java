package com.cmsbackend.controller.course_controller;

import com.cmsbackend.entity.user_course_entity.UserCourse;
import com.cmsbackend.entity.user_entity.User;
import com.cmsbackend.service.course_service.CourseService;
import com.cmsbackend.service.user_course_service.UserCourseService;

import com.cmsbackend.service.user_service.UserService;

import com.cmsbackend.entity.course_entity.Course;
import com.cmsbackend.controller.course_controller.course_vo.CreateRequest;
import com.cmsbackend.controller.course_controller.course_vo.UpdateCourseRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/course")
@CrossOrigin(value = "*")
@Api(tags = {"课程接口"})
public class CourseCenter {
    private final CourseService courseService;
    private final UserService userService;
    private final UserCourseService userCourseService;

    public CourseCenter(CourseService courseService, UserService userService,UserCourseService userCourseService) {
        this.courseService = courseService;
        this.userService = userService;
        this.userCourseService = userCourseService;

    }

    @ApiOperation("新增课程")
    @PostMapping(value = "/new", headers = "Content-Type=application/json", produces = "application/json")
    public String addCourse(@RequestBody CreateRequest request) {
        log.info("Adding new course: {}", request.getName());
        Course course = new Course();
        // 设置课程属性
        course.setName(request.getName());
        course.setTime(request.getTime());
        course.setDept(request.getDept());
        course.setDescription(request.getDescription());
        course.setClassroom(request.getClassroom());
        try {
            courseService.save(course);
            return "新增课程成功，课程名称:" + course.getName();
        } catch (Exception e) {
            log.error("Failed to create course", e);
            throw new RuntimeException("Failed to create course", e);
        }
    }

    @ApiOperation("获取课程信息")
    @GetMapping(value = "/info/{courseId}")
    public Course getCourseInfo(@PathVariable Long courseId) {
        log.info("Fetching info for course: {}", courseId);
        return courseService.getCourseById(courseId);
    }

    @ApiOperation("更新课程信息")
    @PutMapping(value = "/update/{courseId}", headers = "Content-Type=application/json", produces = "application/json")
    public String updateCourseInfo(@PathVariable Long courseId, @RequestBody UpdateCourseRequest request) {
        log.info("Updating course: {}", courseId);
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            throw new RuntimeException("Course not found");
        }
        // 更新课程信息
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setTime(request.getTime());
        course.setDept(request.getDept());
        course.setClassroom(request.getClassroom());
        try {
            courseService.save(course);
            return "课程信息更新成功，课程名称:" + course.getName();
        } catch (Exception e) {
            log.error("Failed to update course info", e);
            throw new RuntimeException("Failed to update course info", e);
        }
    }

    @ApiOperation("删除课程")
    @DeleteMapping("/delete/{courseId}")
    public String deleteCourse(@PathVariable Long courseId) {
        log.info("Deleting course: {}", courseId);
        try {
            courseService.deleteCourseById(courseId);
            return "课程删除成功";
        } catch (Exception e) {
            log.error("Failed to delete course", e);
            throw new RuntimeException("Failed to delete course", e);
        }
    }
//?????
    //给前端返回课程名称
    @ApiOperation("选择课程")
    @PostMapping(value = "/choose/{courseId}", headers = "Content-Type=application/json", produces = "application/json")
    public String chooseCourse(@PathVariable Long courseId,@RequestAttribute("account") String account) {
        log.info("Choosing new course: {}", courseId);
        UserCourse uc = new UserCourse();
        User u = userService.getUserByAccount(account);
        // 设置课程属性
        uc.setCourseId(courseId);
        uc.setUserId(u.getId());
        uc.setIdentiy(u.getIdentity());
        try {
            userCourseService.save(uc);
            return "选择课程成功";
        } catch (Exception e) {
            log.error("Failed to choose course", e);
            throw new RuntimeException("Failed to choose course", e);
        }
    }

    //多表查询
    //注意list中的值需不需要重定义
    @ApiOperation("查看选择的所有课程")
    @GetMapping("/all")
    public List<Course> GetAllCourseInfo(@RequestParam("page") Integer page, @RequestAttribute("account") String account) {

        User u = userService.getUserByAccount(account);
//        if (u.getIdentity() < 1) {
//            throw new RuntimeException("权限不足");
//        }
        System.out.println(u.getId() + "testing");

        List<UserCourse> ucs = userCourseService.getCourseIdByUserId(u.getId(),page - 1, 10);

        List<Course> course = new ArrayList<>();
        for (UserCourse uc : ucs) {
            Course c;
            c = courseService.getCourseById(uc.getCourseId());
            course.add(c);
        }
        System.out.println(course.size());
        return course;
    }


}