package org.csystem.app.io.file.randomaccsess;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public final class RandomAccessFileStandardInput implements AutoCloseable{
    private final RandomAccessFile m_randomAccessFile;
    private final Scanner m_scan;
    private final String m_quitText;
    private final String m_prompt;

    private void runForWrite() throws IOException {
        for(;;){
            System.out.printf(m_prompt);
            String text =  m_scan.nextLine();

            if(text.equals(m_quitText))
                break;

            m_randomAccessFile.writeUTF(text);
        }
    }

    private void runForRead() throws IOException {
        m_randomAccessFile.seek(0); //  dosya pozisyon göstericisini başa çektik

        for(;;) {
            try {
                String text = m_randomAccessFile.readUTF();
                System.out.printf(text);
            }

            catch (EOFException ignore){

            }
        }
    }

    public RandomAccessFileStandardInput(String path,String quitText,String prompt) throws IOException{
        this(path,quitText,prompt,new Scanner(System.in));
    }

    public RandomAccessFileStandardInput(String path,String quitText, String prompt, Scanner scan) throws IOException{
        m_randomAccessFile = new RandomAccessFile(path,"rw");
        m_randomAccessFile.seek(m_randomAccessFile.length()); // Dosyanın sonuna konulandırdık
        m_quitText = quitText;
        m_prompt = prompt;
        m_scan = scan;
    }

    public void run() throws IOException{
        runForWrite();
        runForRead();
    }

    public void close() throws IOException{
        m_randomAccessFile.close();
    }
}