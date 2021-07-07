package com.tsn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 留言类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    private Integer  id;
    private String account;//留言者账号
    private String commenter;//留言人昵称
    private String info;//内容
    private String time;//留言时间

}
