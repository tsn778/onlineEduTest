package com.tsn.mapper;


import com.tsn.pojo.SubinClass;
import com.tsn.pojo.Subject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubinClassMapper {
    List<SubinClass> getSubjectById(Integer classid);


    int addSubinClass(SubinClass subinClass);
    int deleteSubinClass(Integer id);

}
