//package online.k12code.websocket.config;
//
//
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.OnClose;
//import javax.websocket.OnMessage;
//import javax.websocket.OnOpen;
//import javax.websocket.Session;
//import javax.websocket.server.ServerEndpoint;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//import java.util.concurrent.CopyOnWriteArraySet;
//
//@ServerEndpoint("/websocket/wangzhuan-test")
//@Component
//public class WebSocketConnection {
//
//    /**
//     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
//     */
//    private static int ONLINE_COUNT = 0;
//
//    /**
//     * concurrent包的线程安全Set，用来存放每个客户端对应的BigScreenWebSocket对象。
//     */
//    private static CopyOnWriteArraySet<WebSocketConnection> WEB_SOCKET_SET = new CopyOnWriteArraySet<>();
//    /**
//     * 存储新链接标识。
//     */
//    public static Map<String, Object> USER_SESSIONS = new HashMap<>(0);
//    /**
//     * 与某个客户端的连接会话，需要通过它来给客户端发送数据。
//     */
//    private Session session;
//
//
//    /**
//     * 连接建立成功调用的方法
//     */
//    @OnOpen
//    public void onOpen(Session session) throws Exception {
//        System.err.println("session====>"+session);
//        this.session = session;
//        // 生成唯一ID
//        String uuid = String.valueOf(UUID.randomUUID());
//        // 把唯一标识跟客户端绑定
//        USER_SESSIONS.put(uuid, this.session);
//        // 加入set中
//        WEB_SOCKET_SET.add(this);
//        //需要发送到业务数据
//        onMessage("Hello,Websocket");
//    }
//
//    /**
//     * 连接关闭调用的方法
//     */
//    @OnClose
//    public void onClose() {
//        System.err.println("删除");
//        // 从set中删除
//        WEB_SOCKET_SET.remove(this);
//    }
//
//    /**
//     * 收到客户端消息后调用的方法
//     *
//     * @param message 客户端发送过来的消息
//     */
//    @OnMessage
//    public void onMessage(String message) {
//        System.err.println("onMessage===>"+ message);
//        sendMessage(message);
//    }
//
//
//
//    public void sendMessage(String message) {
//        try {
//            for (WebSocketConnection item : WEB_SOCKET_SET) {
//                // 判断链接是否关闭
//                if (item.session.isOpen()) {
//                    synchronized (item.session) {
//                        item.session.getBasicRemote().sendText(message);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}
