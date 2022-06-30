package com.rick.webcoursedesign2022backend.service;

import com.rick.webcoursedesign2022backend.entity.User;

import java.util.List;


public interface UserService {

    User selectUserByCardNumber(String cardNumber);

    void insertOneUser(User user);

    List<User> selectAllTeachers();

    void selectOneTeacher(String teacherCardNumber,String studentCardNumber);

}
