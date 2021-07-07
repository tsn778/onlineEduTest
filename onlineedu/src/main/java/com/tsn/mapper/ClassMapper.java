package com.tsn.mapper;


import com.tsn.pojo.Class;
import com.tsn.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassMapper {
    List<Class> getClasses();

    Class getClassById(Integer cid);
    Class getClassByName(String subname);
    int addClass(Class classes);
    int deleteClass(Integer uid);
    int updateClass(Class classes);


}
