package com.tsn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Material {
   private Integer id;
   private String name;
   private String filePath;
   private Integer subjectId;
}
