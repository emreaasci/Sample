package org.csystem.app.io.file.deviceindependentbitmap;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

public final class DeviceIndependentBitMap implements AutoCloseable{
    private final RandomAccessFile m_bitmapfile;

    public DeviceIndependentBitMap(String path) throws IOException{
        m_bitmapfile = new RandomAccessFile(path,"r");
    }

    public int getWidth() throws IOException{
        m_bitmapfile.seek(18);
        byte [] data = new byte[4];
        m_bitmapfile.read(data);
        //...

        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    public int getHeight() throws IOException{
        m_bitmapfile.seek(22);
        byte [] data = new byte[4];
        m_bitmapfile.read(data);
        //...

        return ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }


    public void close() throws IOException{
        m_bitmapfile.close();
    }
}