package com.tsn.pojo;
/**
 * 用户
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer  uid;
    private String account;
    private String password;
    private String username;
    private String gender;
    private String email;
    private  String phonenumber;
    private String role;
    private String portrait;

}
