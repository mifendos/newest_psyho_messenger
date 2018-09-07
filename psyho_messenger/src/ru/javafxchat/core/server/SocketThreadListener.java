package ru.javafxchat.core.server;

import java.net.Socket;

public interface SocketThreadListener {
    void onStartSocketThread(SocketThread socketThread, Socket socket);

    void onSocketIsReady(SocketThread socketThread, Socket socket);

    void onReceivedString(SocketThread socketThread, Socket socket, String msg);

    void onStopSocketThread(SocketThread socketThread, Socket socket);

}
