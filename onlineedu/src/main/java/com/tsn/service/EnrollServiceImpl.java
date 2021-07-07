package com.tsn.service;

import com.tsn.mapper.EnrollMapper;
import com.tsn.pojo.Enroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollServiceImpl implements EnrollService{
  @Autowired
    EnrollMapper enrollMapper;

    @Override
    public List<Enroll> getEnrolls() {
        return enrollMapper.getEnrolls();
    }

    @Override
    public Enroll getEnrollById(Integer id) {
        return enrollMapper.getEnrollById(id);
    }

    @Override
    public Enroll getEnrollByName(String name) {
        return enrollMapper.getEnrollByName(name);
    }

    @Override
    public int addEnroll(Enroll enroll) {
        return enrollMapper.addEnroll(enroll);
    }

    @Override
    public int deleteEnroll(Integer id) {
        return enrollMapper.deleteEnroll(id);
    }

    @Override
    public int updateEnroll(Enroll enroll) {
        return enrollMapper.updateEnroll(enroll);
    }
}
