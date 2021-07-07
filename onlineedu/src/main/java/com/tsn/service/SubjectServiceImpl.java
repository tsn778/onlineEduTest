package com.tsn.service;

import com.tsn.mapper.SubjectMapper;
import com.tsn.pojo.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService{

    @Autowired
    SubjectMapper subjectMapper;
    @Override
    public List<Subject> getSubjects() {
        return subjectMapper.getSubjects();
    }

    @Override
    public Subject getSubjectById(Integer subid) {
        return subjectMapper.getSubjectById(subid);
    }

    @Override
    public Subject getSubjectByName(String subname) {
        return subjectMapper.getSubjectByName(subname);
    }

    @Override
    public int addSubject(Subject subject) {
        return subjectMapper.addSubject(subject);
    }

    @Override
    public int deleteSubject(Integer uid) {
        return subjectMapper.deleteSubject(uid);
    }

    @Override
    public int updateSubject(Subject subject) {
        return subjectMapper.updateSubject(subject);
    }

    @Override
    public List<Subject> getSubjectsByWord(String word) {
        return subjectMapper.getSubjectsByWord(word);
    }
}
