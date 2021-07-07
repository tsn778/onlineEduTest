package com.tsn.mapper;


import com.tsn.pojo.Enroll;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EnrollMapper {
    List<Enroll> getEnrolls();

    Enroll getEnrollById(Integer id);
    Enroll getEnrollByName(String name);
    int addEnroll(Enroll enroll);
    int deleteEnroll(Integer id);
    int updateEnroll(Enroll enroll);
}
