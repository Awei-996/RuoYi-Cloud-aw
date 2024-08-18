package online.k12code.websocket.controller;

import online.k12code.websocket.config.WebSocketConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Carl
 * @since 6.1.0
 */
@CrossOrigin(origins = "http://localhost")
@Controller
public class ChatController {

    @Autowired
    private WebSocketConnection webSocketConnection;


    @GetMapping("/sendMessage")
    public void sendMessage() {
        webSocketConnection.sendMessage("你好");
        // 手动发送消息到指定的 WebSocket 订阅路径
//        messagingTemplate.convertAndSend("/topic/public", "Hello, WebSocket!");
    }
}