package com.tsn.mapper;

import com.tsn.pojo.Material;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MaterialMapper {
    List<Material> queryMaterialByStuId(Integer subjectId);

}
