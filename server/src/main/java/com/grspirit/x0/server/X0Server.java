package com.grspirit.x0.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.util.Pair;

public class X0Server {
    private static int port = 5678;
    private static Queue<X0Client> clientQueue = new ConcurrentLinkedQueue<>();
    private static ServerSocket serverSocket;
    private static Logger logger = Logger.getGlobal();
    public static void main(String[] args) {
        try {
            setupLogging();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    logger.log(Level.INFO, "Server stopped");
                }
            });
            if (args.length >= 1)
                port = Integer.parseInt(args[0]);
            serverSocket = new ServerSocket(port);
            Logger.getGlobal().log(Level.INFO, "Server started on port {0}", port);
            while (true) {
                Socket soc= serverSocket.accept();
                X0Client client = new X0Client(soc);
                client.sendWaitForPlayer();
                clientQueue.add(client);
                while (clientQueue.size() >= 2) {
                    X0Client client1 = clientQueue.remove();
                    X0Client client2 = clientQueue.remove();
                    if (!client1.getSocket().isConnected() && client2.getSocket().isConnected())
                        clientQueue.add(client2);
                    if (client1.getSocket().isConnected() && !client2.getSocket().isConnected())
                        clientQueue.add(client1);
                    if (client1.getSocket().isConnected() && client2.getSocket().isConnected()) {
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
            dispose();
        }
    }

    private static void setupLogging() throws IOException {
        FileHandler fhandler = new FileHandler("server.log");
        fhandler.setLevel(Level.ALL);
        fhandler.setFormatter(new SimpleFormatter());
        ConsoleHandler chandler = new ConsoleHandler();
        chandler.setLevel(Level.ALL);
        Logger.getGlobal().addHandler(fhandler);
        Logger.getGlobal().addHandler(chandler);
    }

    public static void dispose() {
        try {
            if (serverSocket != null)
                serverSocket.close();
        }
        catch (Exception e){
            System.out.println("Cannot dispose X0Server");
            e.printStackTrace();
        }
    }
}
