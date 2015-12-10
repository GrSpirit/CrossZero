package com.grspirit.x0.server;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by vita on 09.12.15.
 */
public class Game implements Runnable {
    private Socket socket1;
    private Socket socket2;
    public Game(Socket socket1, Socket socket2){
        this.socket1 = socket1;
        this.socket2 = socket2;
    }

    @Override
    public void run() {
        try {
            X0Client client1 = new X0Client(socket1);
            X0Client client2 = new X0Client(socket2);
            client1.sendPlayerNumber(1);
            client2.sendPlayerNumber(2);
            Thread fw1 = new Thread(new StreamForwarder(socket1.getInputStream(), socket2.getOutputStream()));
            Thread fw2 = new Thread(new StreamForwarder(socket2.getInputStream(), socket1.getOutputStream()));
            fw1.start();
            fw2.start();
            fw1.join();
            fw2.join();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (socket1.isConnected())
                    socket1.close();
            }
            catch (Exception x) {}
            try {
                if (socket2.isConnected())
                    socket2.close();
            }
            catch (Exception x) {}
        }
    }
}
