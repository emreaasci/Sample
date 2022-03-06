package org.csystem.app.io.file.compyandbackup;

import java.io.IOException;

public final class CopyAndBackupApp {
    private CopyAndBackupApp(){

    }

    public static void run(String [] args){
        try{
            CopyAndBackup copyAndBackup = new CopyAndBackup(args);

            copyAndBackup.run();
        }

        catch (IOException ex){
            System.err.printf("Dosya işlemi hatası");
        }
        catch (Throwable ex){
            System.err.printf("Beklenmeyen bir durum oluştu");
        }
    }
}
