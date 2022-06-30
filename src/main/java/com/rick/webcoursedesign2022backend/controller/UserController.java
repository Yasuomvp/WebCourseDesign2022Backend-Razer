package com.rick.webcoursedesign2022backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rick.webcoursedesign2022backend.entity.User;
import com.rick.webcoursedesign2022backend.mapper.UserMapper;
import com.rick.webcoursedesign2022backend.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    private final UserMapper userMapper;


    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }


    @GetMapping("/selectAllTeachers")
    List<User> selectAllTeachers(){
        return userService.selectAllTeachers();
    }

    @GetMapping("/selectOneTeacher")
    void selectOneTeacher(@Param("teacherCardNumber")String teacherCardNumber,@Param("studentCardNumber") String studentCardNumber){
        userService.selectOneTeacher(teacherCardNumber,studentCardNumber);
    }


    @GetMapping("/getOne")
    User getOne(@Param("studentCardNumber")String studentCardNumber){
        return userMapper.getOne(studentCardNumber);
    }
}
