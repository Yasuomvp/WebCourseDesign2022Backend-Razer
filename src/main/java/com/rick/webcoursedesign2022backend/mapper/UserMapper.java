package com.rick.webcoursedesign2022backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rick.webcoursedesign2022backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

}
