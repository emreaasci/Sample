package org.csystem.app.io.file;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

final class WriterApp {
    private WriterApp()
    {
    }
    public static void main(String[] args)
    {
        if (args.length != 1) {
            System.err.println("Geçersiz sayıda argümanlar");
            System.exit(-1);
        }

        Random r = new Random();
        Scanner scan =  new Scanner(System.in);

        try (FileOutputStream fos = new FileOutputStream(args[0], true)) {
            DataOutputStream dos =  new DataOutputStream(fos);
            for(;;){
                System.out.print("Bir yazı giriniz");
                String text = scan.nextLine();

                if(text.equals("elma"))
                    break;

                dos.writeUTF(text);


            }
        }
        catch (NumberFormatException ignore) {
            System.err.println("Geçersiz sayı formatı");
        }
        catch (Throwable ex) {
            System.err.printf("Exception:%s", ex.getMessage());
        }
    }
}