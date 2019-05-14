package com.liujie.websocket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
public class SendTask extends TimerTask {

    @Autowired
    private WebSocketServer webSocketServer;
    int count = 0;
    @Override
    public void run() {
//        List<String> sids = webSocketServer.getSids();
        String sid = webSocketServer.getSid();
        CopyOnWriteArraySet<WebSocketServer> webSocketSet = WebSocketServer.webSocketSet;

        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage("这是我第"+ ++count +"次发消息");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        webSocketServer.
//        System.out.println("sids"+sids);
//        System.out.println("sid:"+sid);
//        System.out.println("这是我第"+ ++count +"次发消息");
//        try {
//            WebSocketServer.sendInfo("这是我第"+ ++count +"次发消息",sid);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (String cid :sids){
//            System.out.println(cid);
//            try {
//                System.out.println("这是我第"+ ++count +"次发消息");
//                WebSocketServer.sendInfo("这是我第"+ ++count +"次发消息",cid);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
