package com.mikael.web.component.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.context.support.RequestHandledEvent;


public class Test01Event extends RequestHandledEvent {

    public Test01Event(Object source, String sessionId, String userName, long processingTimeMillis) {
        super(source, sessionId, userName, processingTimeMillis);
    }

    public Test01Event(Object source, String sessionId, String userName, long processingTimeMillis, Throwable failureCause) {
        super(source, sessionId, userName, processingTimeMillis, failureCause);
    }
}
