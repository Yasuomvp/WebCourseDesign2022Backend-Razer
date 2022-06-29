package com.rick.webcoursedesign2022backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rick.webcoursedesign2022backend.entity.User;
import com.rick.webcoursedesign2022backend.mapper.UserMapper;
import com.rick.webcoursedesign2022backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User selectUserByCardNumber(String cardNumber) {
        return userMapper.selectOne(new QueryWrapper<User>().eq("card_number", cardNumber));
    }

    @Override
    public void insertOneUser(User user) {
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        userMapper.insert(user);
    }
}
