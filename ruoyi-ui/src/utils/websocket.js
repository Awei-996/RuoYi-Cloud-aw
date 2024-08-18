// npm install sockjs-client stompjs
import SockJS from "sockjs-client";
import Stomp from "stompjs";
import {getToken} from "./auth";

let stompClient = null;

export function connectWebSocket() {
  if (!getToken()) {
    console.error("No token provided. Cannot connect to WebSocket.");
    return;
  }

    const socket = new SockJS('/ws');  // 使用 SockJS 建立连接
    this.stompClient = Stomp.over(socket);

    this.stompClient.connect({}, frame => {
      console.log('Connected: ' + frame);

      // 订阅服务器推送消息的频道
      this.stompClient.subscribe('/topic/public', message => {
        this.$message.info(message.body)
      });
    });

}

export function sendMessage(destination, message) {
  if (this.stompClient && this.stompClient.connected) {
    this.stompClient.send(destination, {}, JSON.stringify(message));
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
