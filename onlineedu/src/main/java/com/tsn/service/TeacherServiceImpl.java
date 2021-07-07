package com.tsn.service;


import com.tsn.mapper.TeacherMapper;
import com.tsn.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
   @Autowired
    TeacherMapper teacherMapper;
    @Override
    public List<Teacher> getTeachers() {
        return teacherMapper.getTeachers();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public Teacher getTeacherByName(String tchname) {
        return teacherMapper.getTeacherByName(tchname);
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int deleteTeacher(Integer uid) {
        return teacherMapper.deleteTeacher(uid);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }
}
