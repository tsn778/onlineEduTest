package com.tsn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 讲师类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    private Integer  id;
    private String tchname;
    private String tchgender;
    private String tchinfo;//讲师介绍
    private String duty;//职位
    private String portrait;

}
