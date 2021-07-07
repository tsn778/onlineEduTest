package com.tsn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    private Integer  subid;
    private String subname;
    private String teacher;
    private String period;//课时
    private String introduction;//简介
    private String subinfo;//内容
    private String state;//状态
    private String subtype;//课程开始时间
    private String regtime;//报名时间
    private String regend;//报名结束时间
    private String coverpath;//封面位置

}
