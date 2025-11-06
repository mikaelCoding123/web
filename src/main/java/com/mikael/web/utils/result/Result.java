package com.mikael.web.utils.result;

import lombok.*;
import lombok.experimental.Accessors;
import org.slf4j.MDC;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public  class Result implements Serializable {
    private final static long serialVersionUID = 1L;

//    private String traceId= MDC.getCopyOfContextMap().get("traceId");
    private String traceId;
    private Integer code;
    private String msg;
    private Object data;
    private long timestamp;
}
