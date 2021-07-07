package com.tsn.service;


import com.tsn.pojo.Work;

import java.util.List;

public interface WorkService {


    List<Work> getWorks();

    Work getWorkById(Integer wid);
    Work getWorkByName(String workname);
    int addWork(Work work);
    int deleteWork(Integer wid);
    int updateWork(Work work);
}
