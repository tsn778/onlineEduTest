package com.tsn.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程优秀作品
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Work {
    private Integer  wid;
    private String workname;
    private String author;//作者
    private String message;//作者留语
    private String address;//所属课程，也可为自己作品
    private String picpath;//作品地址
}
