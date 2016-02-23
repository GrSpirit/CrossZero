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
public class X0Client implements Disposable {
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

    public Socket getSocket() {
        return this.socket;
    }

    public void sendPlayerNumber(int playerNumber) throws IOException{
        ByteArrayBuffer data =  new ByteArrayBuffer();
        DataOutputStream buffer = new DataOutputStream(data);
        buffer.writeInt(playerNumber);
        buffer.flush();
        writeData(Game.PLAYER_NUMBER_CMD, data.getRawData());
    }

    public void sendWaitForPlayer() throws IOException {
        writeData(Game.WAIT_FOR_PLAYER);
    }

    private void writeData(int command, byte[] data) throws IOException {
        out.writeShort(command);
        out.writeShort(data.length);
        out.write(data);
    }

    private void writeData(int command) throws IOException {
        out.writeShort(command);
        out.writeShort(0);
    }

    @Override
    public void dispose() {
        try {
            this.socket.close();
        }
        catch (Exception e){

        }
    }
}
