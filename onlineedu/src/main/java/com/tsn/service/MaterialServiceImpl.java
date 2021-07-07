package com.tsn.service;

import com.tsn.mapper.MaterialMapper;
import com.tsn.pojo.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialServiceImpl implements  MaterialService{
    @Autowired
    private MaterialMapper materialMapper;
    @Override
    public List<Material> queryMaterialByStuId(Integer subjectId) {
        return materialMapper.queryMaterialByStuId(subjectId);
    }
}
