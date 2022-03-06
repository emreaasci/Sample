package org.csystem.app.io.file.devicepersistence;

import java.io.IOException;

public final class DevicesPersistenceRunner {
    private DevicesPersistenceMenuApp m_randomAccessFileStandardInput;

    private DevicesPersistenceRunner(){

    }
    public static void run()
    {
        try (DevicesPersistenceMenuApp dpma =  new DevicesPersistenceMenuApp("devices.dat")) {
            dpma.run();
        }

        catch (IOException ignore){
            System.out.printf("Bir problem oluştu");
        }
    }
}
