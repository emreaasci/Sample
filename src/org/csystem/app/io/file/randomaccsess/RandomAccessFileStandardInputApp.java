package org.csystem.app.io.file.randomaccsess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;

public final class RandomAccessFileStandardInputApp {
    private RandomAccessFileStandardInput m_randomAccessFileStandardInput;

    private RandomAccessFileStandardInputApp(){

    }
    public static void run(String[] args)
    {
        if (args.length != 1) {
            System.err.println("Geçersiz sayıda argüman");
            System.exit(1);
        }

        try (RandomAccessFileStandardInput ra =  new RandomAccessFileStandardInput(args[0],"elma","bir yazı giriniz")) {
            ra.run();
        }

        catch (IOException ignore){
            System.out.printf("Bir problem oluştu");
        }

    }
}
