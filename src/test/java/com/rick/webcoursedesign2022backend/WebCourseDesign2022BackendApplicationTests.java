package com.rick.webcoursedesign2022backend;

import com.rick.webcoursedesign2022backend.entity.User;
import com.rick.webcoursedesign2022backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.ResponseStatus;

@SpringBootTest
class WebCourseDesign2022BackendApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        User user = new User();
        user.setCardNumber("2222222222");
        user.setPassword("131213");
        user.setName("rick");
        user.setTotal(5);
        user.setSelected(0);
        user.setIst("1");
        userService.insertOneUser(user);
    }

    @Test
    void test1(){
        User user = userService.selectUserByCardNumber("2019214081");
        System.out.println(user);
    }

    @Test
    void test2(){
        System.out.println(userService.selectAllTeachers());
    }

}
