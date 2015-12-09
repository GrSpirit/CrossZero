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

    protected void forwardStreams() throws IOException {
        byte[] data = new byte[1024];
        int bytesRead;
        while ((bytesRead = socket1.getInputStream().read(data)) >= 0) {
            socket2
        }
    }
}
