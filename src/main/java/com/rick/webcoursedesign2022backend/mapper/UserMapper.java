package com.rick.webcoursedesign2022backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rick.webcoursedesign2022backend.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Update("update user set selected = selected + 1 where card_number = #{teacherCardNumber}")
    int selectOneTeacher(@Param("teacherCardNumber") String teacherCardNumber);


    @Insert("insert into t_and_s(teacher_number,student_number) values(#{teacherCardNumber},#{studentCardNumber})")
    int selectOneTeacherRelationShip(@Param("teacherCardNumber") String teacherCardNumber,@Param("studentCardNumber") String studentCardNumber);


    @Select("select user.* from user where card_number = (select teacher_number from t_and_s where student_number = #{studentCardNumber})")
    User getOne(@Param("studentCardNumber")String studentCardNumber);
}
