package com.tsn.service;

import com.tsn.mapper.ClassMapper;
import com.tsn.mapper.SubinClassMapper;
import com.tsn.pojo.Class;
import com.tsn.pojo.SubinClass;
import com.tsn.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassServiceImpl implements ClassService{

    @Autowired
    ClassMapper classMapper;
    @Autowired
    SubinClassMapper subinClassMapper;


    @Override
    public List<Class> getClasses() {
        return classMapper.getClasses();
    }

    @Override
    public Class getClassById(Integer cid) {
        return classMapper.getClassById(cid);
    }

    @Override
    public Class getClassByName(String subname) {
        return classMapper.getClassByName(subname);
    }

    @Override
    public int addClass(Class classes) {
        return classMapper.addClass(classes);
    }

    @Override
    public int deleteClass(Integer uid) {
        return classMapper.deleteClass(uid);
    }

    @Override
    public int updateClass(Class classes) {
        return classMapper.updateClass(classes);
    }

    @Override
    public List<SubinClass> getSubjectById(Integer classid) {
        return subinClassMapper.getSubjectById(classid);
    }

    @Override
    public int addSubinClass(SubinClass subinClass) {
        return subinClassMapper.addSubinClass(subinClass);
    }

    @Override
    public int deleteSubinClass(Integer id) {
        return subinClassMapper.deleteSubinClass(id);
    }
}
