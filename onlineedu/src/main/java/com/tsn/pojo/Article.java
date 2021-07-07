package com.tsn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private Integer id;
    private String articlename;
    private String author;

    private String introduction;//简介
    private String info;//内容
    private Integer state;//状态
    private String articletype;//课程开始时间
    private String fristtime;//创建时间
    private String endtime;//最后修改时间时间
    private String filepath;//附件位置
    private String editor;
}
