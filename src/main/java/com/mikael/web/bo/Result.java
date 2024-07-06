package com.mikael.web.bo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public  class Result {
    private int code;
    private String msg;
    private Object data;
}
