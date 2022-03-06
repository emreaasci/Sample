package org.csystem.app.io.file.deviceindependentbitmap;

import java.io.IOException;

public final class DeviceIndependentBitMapApp {
    private DeviceIndependentBitMap m_randomAccessFileStandardInput;

    private DeviceIndependentBitMapApp(){

    }
    public static void run(String[] args)
    {
        if (args.length != 1) {
            System.err.println("Geçersiz sayıda argüman");
            System.exit(1);
        }

        try (DeviceIndependentBitMap dib =  new DeviceIndependentBitMap(args[0])) {
            System.out.printf("%d x %d",dib.getWidth(),dib.getHeight());
        }

        catch (IOException ignore){
            System.out.printf("Bir problem oluştu");
        }

    }
}
