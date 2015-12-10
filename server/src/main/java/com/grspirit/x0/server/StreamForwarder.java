package com.grspirit.x0.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by vita on 10.12.15.
 */
class StreamForwarder implements Runnable {
    private InputStream inputStream;
    private OutputStream outputStream;

    public StreamForwarder(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    @Override
    public void run() {
        try {
            int cmd = 0;
            int size = 0;
            int total_read;
            int read;
            byte[] data = new byte[1024];
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            do {
                cmd = in.readShort();
                size = in.readShort();
                total_read = 0;
                do {
                    read = in.read(data, total_read, size - total_read);
                    total_read += read;
                }
                while (total_read < size && read > 0);

                out.writeShort(cmd);
                out.writeShort(size);
                out.write(data, 0, size);
            }
            while (cmd != 9);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
