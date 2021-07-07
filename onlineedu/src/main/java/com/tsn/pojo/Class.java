package com.tsn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 班级类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    private Integer  cid;
    private String classname;
    private String teacher;
    private String period;//课时
    private String introduction;//简介
    private String classinfo;//内容
    private String state;//状态
    private String starttime;//课程开始时间
    private String regtime;//报名时间
    private String regend;//报名结束时间
    private String coverpath;//封面位置
    private String price;//价格
    private String workis;//是否需要作品
}
