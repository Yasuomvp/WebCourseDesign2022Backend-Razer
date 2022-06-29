package com.rick.webcoursedesign2022backend.service;

import com.rick.webcoursedesign2022backend.entity.User;


public interface UserService {

    User selectUserByCardNumber(String cardNumber);

    void insertOneUser(User user);

}
