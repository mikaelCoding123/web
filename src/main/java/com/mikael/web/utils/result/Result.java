package com.mikael.web.utils.result;

import lombok.*;
import lombok.experimental.Accessors;
import org.slf4j.MDC;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public  class Result {

//    private String traceId= MDC.getCopyOfContextMap().get("traceId");
    private String traceId;
    private Integer code;
    private String msg;
    private Object data;
    private long timestamp;
}
