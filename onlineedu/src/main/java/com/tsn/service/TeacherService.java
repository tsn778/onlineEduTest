package com.tsn.service;

import com.tsn.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getTeachers();//得到所有用户

    Teacher getTeacherById(Integer id);//通过uid查询用户
    Teacher getTeacherByName(String tchname);
    int addTeacher(Teacher teacher);
    int deleteTeacher(Integer uid);
    int updateTeacher(Teacher teacher);
}
