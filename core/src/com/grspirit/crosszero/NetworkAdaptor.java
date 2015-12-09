package com.grspirit.crosszero;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by vita on 08.12.15.
 */
public class NetworkAdaptor {
    Socket socket;
    DataInputStream inputStream;
    DataOutputStream outputStream;

    public NetworkAdaptor() throws UnknownHostException, IOException {
        InetAddress ipAddress = InetAddress.getByAddress(new byte[] {0,0,0,0});
        socket = new Socket(ipAddress, 5678);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void sendTurn(int x, int y) throws IOException {
        outputStream.writeInt(x);;
        outputStream.writeInt(y);
    }

    public void receiveTurn(Integer x, Integer y) throws IOException{
        x = inputStream.readInt();
        y = inputStream.readInt();
    }
}
