// npm install sockjs-client stompjs
import SockJS from "sockjs-client";
import Stomp from "stompjs";
import {getToken} from "./auth";
import {Message} from "element-ui";

let stompClient = null;

export function connectWebSocket() {
  if (!getToken()) {
    console.error("No token provided. Cannot connect to WebSocket.");
    return;
  }

    const socket = new SockJS('/ws');  // 使用 SockJS 建立连接
    stompClient = Stomp.over(socket);

    stompClient.connect({}, frame => {
      if (frame?.command == "CONNECTED") {
        console.log("websocket连接成功")
      }      // 订阅服务器推送消息的频道
      stompClient.subscribe('/topic/public', message => {
        Message.info(message.body)
      });
    });

}

export function sendMessage(destination, message) {
  if (stompClient && stompClient.connected) {
    stompClient.send(destination, {}, JSON.stringify(message));
  } else {
    console.error("WebSocket is not connected. Cannot send message.");
  }
}

export function disconnectWebSocket() {
  if (stompClient !== null) {
    stompClient.disconnect();
  }
  console.log("Disconnected");
}
