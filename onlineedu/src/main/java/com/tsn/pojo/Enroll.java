package com.tsn.pojo;
/**
 * 报名信息
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enroll {

    private Integer  id;
    private String name;
    private String classes;
    private String age;
    private String gender;

    private  String phonenumber;
    private String qq;
    private String email;
    private String address;
    private Integer state;
    private String basics;//基础
    private String info;//备注自我介绍


    private String work;//作品
    private String account;
}
