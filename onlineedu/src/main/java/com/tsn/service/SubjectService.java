package com.tsn.service;

import com.tsn.pojo.Subject;

import java.util.List;

public interface SubjectService {
  public   List<Subject> getSubjects();

    public  Subject getSubjectById(Integer subid);
    public  Subject getSubjectByName(String subname);
    public   int addSubject(Subject subject);
    public  int deleteSubject(Integer uid);
    public int updateSubject(Subject subject);
    List<Subject> getSubjectsByWord(String word);
}
