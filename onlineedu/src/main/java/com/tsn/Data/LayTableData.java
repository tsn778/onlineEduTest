package com.tsn.Data;

import lombok.Data;

import java.util.List;

@Data
public class LayTableData {

    Integer code;
    String msg;
    Integer count;
    List<?> data;
}
