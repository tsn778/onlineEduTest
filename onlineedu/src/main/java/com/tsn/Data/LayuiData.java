package com.tsn.Data;


import lombok.Data;

import java.util.List;

@Data
public class LayuiData {
    Integer code;
    String msg;
    List<?> data;
}
