package com.jets.mad.itischeduleapp.datalayer.Services.Token;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.jets.mad.itischeduleapp.R;
import com.jets.mad.itischeduleapp.UI.Activity.MainActivity;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

import ua.naiksoftware.stomp.Stomp;
import ua.naiksoftware.stomp.client.StompClient;

/**
 * Created by ehabm on 6/4/2017.
 */

public class SocketService extends Service {

    private WebSocketClient webSocketClient;
    private StompClient mStompClient;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //connectViaSocket();
        connectViaStomp();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new Notification.Builder(this)
                .setContentTitle("Socket")
                .setContentText("socket service")
                .setSmallIcon(R.mipmap.ic_notifications_black_24dp)
                .setContentIntent(pendingIntent)
                .setTicker("Listening")
                .build();

        startForeground(1, notification);
        return START_STICKY;
    }

    private void connectViaSocket(){
        URI uri;
        try {
            uri = new URI("ws://192.168.1.17:6666/websockets/game");
            webSocketClient = new WebSocketClient(uri,new Draft_17()) {
                @Override
                public void onOpen(ServerHandshake handshakedata) {
                    Log.i("WS","opened"+handshakedata.getHttpStatus());
                    webSocketClient.send("Hello from "+ Build.MANUFACTURER + " " +Build.MODEL);
                }

                @Override
                public void onMessage(String message) {
                    final String msg = message;
                    Log.i("WS","data>>>"+message);
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {
                    Log.i("WS","closed"+reason+code+remote);
                    //stopSelf();
                }

                @Override
                public void onError(Exception ex) {
                    System.out.println(ex.getMessage());
                    Log.i("WS","Error>>>"+ex.getMessage());
                }
            };
            webSocketClient.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg){
        webSocketClient.send(msg);
    }

    private void connectViaStomp(){
        mStompClient = Stomp.over(WebSocket.class, "ws://192.168.43.73:8084/WebsoketServer/stomp/websocket");
        mStompClient.connect();

        System.out.println(mStompClient.isConnected());
        mStompClient.topic("/topic/greetings")
                .subscribe(topicMessage -> {
                    Log.i("WS", topicMessage.getPayload());
                });
        mStompClient.lifecycle().subscribe(lifecycleEvent -> {
            switch (lifecycleEvent.getType()) {

                case OPENED:
                    Log.d("WS", "Stomp connection opened");
                    break;

                case ERROR:
                    Log.e("WS", "Error", lifecycleEvent.getException());
                    break;

                case CLOSED:
                    Log.d("WS", "Stomp connection closed");
                    stopSelf();
                    break;
            }
        });
    }
}
