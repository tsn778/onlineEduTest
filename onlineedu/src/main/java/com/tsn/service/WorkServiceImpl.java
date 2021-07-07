package com.tsn.service;

import com.tsn.mapper.WorkMapper;
import com.tsn.pojo.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService{
    @Autowired
    WorkMapper workMapper;

    @Override
    public List<Work> getWorks() {
        return workMapper.getWorks();
    }

    @Override
    public Work getWorkById(Integer wid) {
        return workMapper.getWorkById(wid);
    }

    @Override
    public Work getWorkByName(String workname) {
        return workMapper.getWorkByName(workname);
    }

    @Override
    public int addWork(Work work) {
        return workMapper.addWork(work);
    }

    @Override
    public int deleteWork(Integer wid) {
        return workMapper.deleteWork(wid);
    }

    @Override
    public int updateWork(Work work) {
        return workMapper.updateWork(work);
    }
}
