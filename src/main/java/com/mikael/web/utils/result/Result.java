package com.mikael.web.utils.result;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public  class Result {
    private Integer code;
    private String msg;
    private Object data;
}
