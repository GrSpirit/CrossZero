package com.grspirit.x0.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javafx.util.Pair;

public class X0Server {
    private static int port = 5678;
    private static Queue<Socket> clientQueue = new ConcurrentLinkedQueue<>();
    private static ServerSocket serverSocket;
    public static void main(String[] args) {
        try {
            if (args.length >= 1)
                port = Integer.parseInt(args[0]);
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket client = serverSocket.accept();
                clientQueue.add(client);
                while (clientQueue.size() >= 2) {
                    Socket client1 = clientQueue.remove();
                    Socket client2 = clientQueue.remove();
                    if (!client1.isConnected() && client2.isConnected())
                        clientQueue.add(client2);
                    if (client1.isConnected() && !client2.isConnected())
                        clientQueue.add(client1);
                    if (client1.isConnected() && client2.isConnected()) {
                        Thread thread = new Thread(new Game(client1, client2));
                        thread.start();
                    }
                }
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            }
            catch (Exception x){}
        }
    }
}
