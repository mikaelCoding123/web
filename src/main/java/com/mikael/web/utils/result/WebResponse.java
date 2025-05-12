package com.mikael.web.utils.result;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

@Deprecated
public class WebResponse extends ResponseEntity<Object> {
    public WebResponse(HttpStatusCode status) {
        super(status);
    }

    public WebResponse(Object body, HttpStatusCode status) {
        super(body, status);
    }

    public WebResponse(MultiValueMap<String, String> headers, HttpStatusCode status) {
        super(headers, status);
    }

    public WebResponse(Object body, MultiValueMap<String, String> headers, int rawStatus) {
        super(body, headers, rawStatus);
    }

    public WebResponse(Object body, MultiValueMap<String, String> headers, HttpStatusCode statusCode) {
        super(body, headers, statusCode);
    }
}
