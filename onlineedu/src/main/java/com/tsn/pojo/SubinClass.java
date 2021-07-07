package com.tsn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubinClass {
    private Integer  Id;
    private Integer  subid;
    private Integer  classid;
    private List<SubinClass> nodes = new ArrayList();


}
