package online.k12code.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
///**
// * @author Carl
// * @since 6.1.0
// */

@RestController
public class ChatController {
    private SseEmitter sseEmitter = new SseEmitter(Long.MAX_VALUE);


    @CrossOrigin(origins = "http://localhost")
    @GetMapping("/sse")
    public SseEmitter streamSse() {
        System.err.println(sseEmitter);
        // 返回全局的SseEmitter实例
        return sseEmitter;
    }
    @GetMapping("/send-event")
    public String sendEvent() {
        try {
            System.err.println("sendEvent");
            sseEmitter.send("message");
        } catch (Exception e) {
            // 发生异常时，重置SseEmitter
            sseEmitter = new SseEmitter(Long.MAX_VALUE);
            return "error";
        }
        return "success";
    }

//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;
//
//
//    @GetMapping("/sendMessage")
//    public void sendMessage() {
//        // 手动发送消息到指定的 WebSocket 订阅路径
//        messagingTemplate.convertAndSend("/topic/public", "Hello, WebSocket!");
//    }
//
//    @MessageMapping("hello")
//    @SendTo("/topic/public")
//    public String greeting(String message) throws Exception {
//        System.err.println("收到消息：" + message);
//        return "Hello, " + message + "!";
//    }
}