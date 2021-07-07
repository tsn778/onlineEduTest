package com.tsn.mapper;

import com.tsn.pojo.Subject;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubjectMapper {

    List<Subject> getSubjects();

    Subject getSubjectById(Integer subid);
    Subject getSubjectByName(String subname);
    int addSubject(Subject subject);
    int deleteSubject(Integer uid);
    int updateSubject(Subject subject);
    List<Subject> getSubjectsByWord(String word);
}
