package com.grspirit.x0.server;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by vita on 09.12.15.
 */
public class Game implements Runnable {
    public static final int WAIT_FOR_PLAYER = 1;
    public static final int PLAYER_NUMBER_CMD = 2;
    public static final int STOP = 9;
    private X0Client client1;
    private X0Client client2;
    public Game(X0Client client1, X0Client client2){
        this.client1 = client1;
        this.client2 = client2;
    }

    @Override
    public void run() {
        try {
            client1.sendPlayerNumber(1);
            client2.sendPlayerNumber(2);
            Thread fw1 = new Thread(
                    new StreamForwarder(
                            client1.getSocket().getInputStream(), client2.getSocket().getOutputStream()));
            Thread fw2 = new Thread(
                    new StreamForwarder(
                            client2.getSocket().getInputStream(), client1.getSocket().getOutputStream()));
            fw1.start();
            fw2.start();
            fw1.join();
            fw2.join();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            client1.dispose();
            client2.dispose();
        }
    }
}
