package com.tsn.service;

import com.tsn.pojo.Material;

import java.util.List;

public interface MaterialService {
    List<Material> queryMaterialByStuId(Integer subjectId);
}
