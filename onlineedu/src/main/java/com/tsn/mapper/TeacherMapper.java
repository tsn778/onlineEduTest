package com.tsn.mapper;

import com.tsn.pojo.Teacher;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherMapper {
    List<Teacher> getTeachers();//得到所有用户

    Teacher getTeacherById(Integer id);//通过uid查询用户
    Teacher getTeacherByName(String tchname);
    int addTeacher(Teacher teacher);
    int deleteTeacher(Integer uid);
    int updateTeacher(Teacher teacher);
}
