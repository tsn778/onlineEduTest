package com.tsn.mapper;

import com.tsn.pojo.Subject;
import com.tsn.pojo.Work;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkMapper {
    List<Work> getWorks();

    Work getWorkById(Integer wid);
    Work getWorkByName(String workname);
    int addWork(Work work);
    int deleteWork(Integer wid);
    int updateWork(Work work);
}
