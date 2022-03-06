package org.csystem.app.io.file.copyfilewithblock;

import java.io.IOException;

public final class CopyFileWithBlockApp {
    private CopyFileWithBlockApp(){

    }

    public static void run(String [] args){
        try{
            CopyFileWithBlock copyFile = new CopyFileWithBlock(args);

            copyFile.run();
        }

        catch (IOException ex){
            System.err.printf("Dosya işlemi hatası");
        }
        catch (Throwable ex){
            System.err.printf("Beklenmeyen bir durum oluştu");
        }
    }
}
