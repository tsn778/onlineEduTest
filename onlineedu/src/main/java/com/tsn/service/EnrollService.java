package com.tsn.service;

import com.tsn.pojo.Enroll;

import java.util.List;

public interface EnrollService {
    List<Enroll> getEnrolls();

    Enroll getEnrollById(Integer id);
    Enroll getEnrollByName(String name);
    int addEnroll(Enroll enroll);
    int deleteEnroll(Integer id);
    int updateEnroll(Enroll enroll);
}
