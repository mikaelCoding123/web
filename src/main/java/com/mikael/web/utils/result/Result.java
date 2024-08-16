package com.mikael.web.utils.result;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public  class Result {
    private Integer code;
    private String msg;
    private Object data;
}
