package com.grspirit.x0.server;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vita on 09.12.15.
 */
public class X0Client {
    public static int PLAYER_NUMBER_CMD = 1;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private DataInputStream in;
    private DataOutputStream out;

    public X0Client(Socket socket) throws IOException {
        this.socket = socket;
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        in = new DataInputStream(inputStream);
        out = new DataOutputStream(outputStream);
    }

    public void sendPlayerNumber(int playerNumber) throws IOException{
        ByteArrayBuffer data =  new ByteArrayBuffer();
        DataOutputStream buffer = new DataOutputStream(data);
        buffer.writeInt(playerNumber);
        buffer.flush();
        out.writeShort(PLAYER_NUMBER_CMD);
        out.writeShort(data.size());
        out.write(data.getRawData());
    }
}
