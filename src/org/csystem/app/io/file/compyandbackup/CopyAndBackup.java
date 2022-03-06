package org.csystem.app.io.file.compyandbackup;

import org.csystem.util.CommandLineUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public final class CopyAndBackup {
    private Path m_sourcePath;
    private Path m_destinationPath;

    private void parseCommandLineArgs(String [] args){
        if(args.length != 2 && args.length != 0){
            System.err.println("Kullanım : java CopyAndBackup <kaynak dosya> <hedef dosya>");
            System.exit(-1);
        }

        args = CommandLineUtil.getArguments(args, "kaynak dosya ve hedef dosya yol ifadeleriniz giriniz", new Scanner(System.in));

        if(args.length == 2){
            m_sourcePath = Path.of(args[0]);
            m_destinationPath = Path.of(args[1]);
        }
        else{
            String [] cmds = args[0].split("[ \t]+");

            m_sourcePath = Path.of(cmds[0]);
            m_destinationPath = Path.of(cmds[1]);
        }
    }
    public void copy(String message) throws IOException {
        Files.copy(m_sourcePath,m_destinationPath);
        System.out.printf(message);
    }

    public void backupAndCopy() throws IOException {
        Files.move(m_destinationPath,Path.of(m_destinationPath.toString() + "-bak"), StandardCopyOption.REPLACE_EXISTING);
        this.copy("Kopyalama Tamamlandı ve Yedeklendi");
    }

    public void copy() throws IOException{
        try{
            this.copy("Kopyalama Başarıyla Yapıldı");
        }

        catch (FileAlreadyExistsException ignore){
            this.backupAndCopy();
        }
    }

    public CopyAndBackup(String [] args){
        this.parseCommandLineArgs(args);
    }

    public void run() throws IOException{
        try{
            this.copy();
        }

        catch (NoSuchFileException ignore) {
            System.err.println("Kaynak dosya bulunamadı");
        }
    }
}
