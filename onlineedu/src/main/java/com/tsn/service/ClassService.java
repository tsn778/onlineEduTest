package com.tsn.service;

import com.tsn.pojo.Class;
import com.tsn.pojo.SubinClass;
import com.tsn.pojo.Subject;

import java.util.List;

public interface ClassService {



  public  List<Class> getClasses();

    public Class getClassById(Integer cid);
    public  Class getClassByName(String subname);
    public  int addClass(Class classes);
    public  int deleteClass(Integer uid);
    public int updateClass(Class classes);
  List<SubinClass> getSubjectById(Integer classid);


  int addSubinClass(SubinClass subinClass);
  int deleteSubinClass(Integer id);
}
