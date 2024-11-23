package com.mikael.web.service.Imp;


import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;


@Component
@CrossOrigin(origins = "*")
@Slf4j
@ServerEndpoint("/ws1")
public class WebSocketServiceImp {

    @OnOpen
    public void onOpen(Session session) {
        log.info("onOpen"+session.getId());
    }

    //当接收到消息时触发
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info(session.getId() +"onMessage" + message);


    }


}
