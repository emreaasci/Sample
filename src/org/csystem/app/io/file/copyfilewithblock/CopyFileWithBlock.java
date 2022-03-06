package org.csystem.app.io.file.copyfilewithblock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileWithBlock {
    private String m_sourcePath;
    private String m_destinationPath;
    private int m_blockSize;

    private static boolean isValidBlockSize(String str){
        boolean result = true;

        try{
            int val = Integer.parseInt(str);
            result = val > 0;
        }

        catch (NumberFormatException ignore){
            result = false;
        }

        return result;
    }

    private void parseCommandLineArgs(String [] args){
        if(args.length != 3){
            System.err.println("Geçersiz argüman sayısı");
            System.exit(-1);

        }

        m_sourcePath = args[0];
        m_destinationPath = args[0];
        if(!isValidBlockSize(args[1])){
            System.err.println("Geçersiz block sayısı");
            System.exit(1);
        }

        m_blockSize = Integer.parseInt(args[2]);
    }

    private void copy() throws IOException {



        try(FileOutputStream fos = new FileOutputStream(m_destinationPath);
             FileInputStream fis = new FileInputStream(m_sourcePath)){

            byte [] buffer = new byte[m_blockSize];
            int result;

            while((result = fis.read(buffer)) > 0)
                fos.write(buffer,0, result);

            System.out.printf("Dosya başarıyla kopyalandı");

        }
        catch (FileNotFoundException ignore){
            System.err.println("Kaynak dosya bulunamadı");
        }


    }

    public CopyFileWithBlock(String [] args){
        this.parseCommandLineArgs(args);
    }

    public void run() throws IOException {
        this.copy();
    }


}
