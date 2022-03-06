package org.csystem.app.io.file.concatfiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ConcatFiles {
    private final ArrayList<Path> m_sourcePaths =  new ArrayList<>();
    private File m_destinationPath;


    private void parseCommandLineArgs(String [] args)
    {
        if (args.length < 2) {
            System.err.println("Geçersiz sayıda argüman");
            System.exit(1);
        }

        for(int i = 0;i < args.length - 1;i++){
            m_sourcePaths.add(Path.of(args[i]));
        }
        m_destinationPath = new File(args[args.length - 1]);
        m_destinationPath.delete();
    }

    private void concat() throws IOException
    {
        try (FileOutputStream fos = new FileOutputStream(m_destinationPath,true)){
            for(Path paths : m_sourcePaths)
                Files.copy(paths,fos);
        }
        catch (FileNotFoundException ignore) {
            System.err.println("Kaynak dosya bulunamadı");
            m_destinationPath.delete();
        }
    }

    public ConcatFiles(String [] args)
    {
        this.parseCommandLineArgs(args);
    }

    public void run() throws IOException
    {
        this.concat();
    }
}
