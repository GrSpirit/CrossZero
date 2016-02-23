package com.grspirit.x0.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by vita on 21.02.16.
 */
public class Test {
    public static void main(String[] args) {
        int command;
        int length;
        byte[] data = new byte[255];
        try {
            System.out.println("Test started");
            Socket socket = new Socket("localhost", 5678);
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            // Read confirmation
            command = in.readShort();
            length = in.readShort();
            System.out.printf("Read %02X\n", command);

            command = in.readShort();
            length = in.readShort();
            if (in.read(data) != length) {
                System.out.println("Wrong data length");
            }
            printData(command, length, data);
        }
        catch (Exception e) {
            System.out.println("Test failed");
            e.printStackTrace();
        }
    }

    private static void printData(int command, int length, byte[] data) {
        System.out.printf("Read %02X[%d][", command, length);
        for (int i = 0; i < length; ++i) {
            System.out.printf("%02X", data[i]);
        }
        System.out.printf("]\n");
    }
}
