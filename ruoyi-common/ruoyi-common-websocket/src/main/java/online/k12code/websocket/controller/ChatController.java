package online.k12code.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Carl
 * @since 6.1.0
 */
//@CrossOrigin(origins = "http://localhost")
@Controller
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @GetMapping("/sendMessage")
    public void sendMessage() {
        // 手动发送消息到指定的 WebSocket 订阅路径
        messagingTemplate.convertAndSend("/topic/public", "Hello, WebSocket!");
    }

    @MessageMapping("hello")
    @SendTo("/topic/public")
    public String greeting(String message) throws Exception {
        System.err.println("收到消息：" + message);
        return "Hello, " + message + "!";
    }
}