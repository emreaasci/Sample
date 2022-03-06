package org.csystem.app.io.file.devicepersistence;

import org.csystem.app.io.file.devicepersistence.entity.DeviceInfo;
import org.csystem.util.Console;

import java.io.*;
import java.util.Scanner;

public final class DevicesPersistenceMenuApp implements Closeable {
    private final RandomAccessFile m_devicesFile;
    private final Scanner m_scan = new Scanner(System.in);

    private void displayMenu(){
        System.out.println("1.Ekle");
        System.out.println("2.Listele");
        System.out.println("3.Çıkış");
        System.out.print("Seçenek:");
    }

    private DeviceInfo getDevicesByStandardInput() {
        int id = Console.readIntLine("Id değerini giriniz:","Hatalı Giriş yaptınız!");
        System.out.println("Adını giriniz:");
        String name = m_scan.nextLine();

        System.out.printf("Host Bilgisini giriniz:");
        String host = m_scan.nextLine();

        return new DeviceInfo(id,name,host);

    }

    private DeviceInfo getDeviceByFile() throws IOException{
        int id = m_devicesFile.readInt();
        String name = m_devicesFile.readUTF();
        String host = m_devicesFile.readUTF();

        //Format kontrolu yapılmalı ama burada ele alınmayacak

        return new DeviceInfo(id,name,host);

    }

    private void doWorkForOption(int option) throws IOException{
        switch (option) {
            case 1:
                this.insertProc();
                break;
            case 2:
                this.listProc();
                break;
            case 3:
                this.quitProc();
                break;
            default:
                System.out.println("Geçersiz Seçenek");
        }
    }

    private void insertProc() throws IOException{
        m_devicesFile.seek(m_devicesFile.length());
        DeviceInfo deviceInfo = this.getDevicesByStandardInput();
        m_devicesFile.seek(m_devicesFile.length());
        m_devicesFile.writeInt(deviceInfo.getId());
        m_devicesFile.writeUTF(deviceInfo.getName());
        m_devicesFile.writeUTF(deviceInfo.getHost());
    }

    private void listProc() throws IOException{
        try{
            m_devicesFile.seek(0);
            for(;;){
                DeviceInfo deviceInfo = this.getDeviceByFile();
                System.out.println(deviceInfo.toString());
            }
        }

        catch (EOFException ignore){

        }
    }

    private void quitProc() {
        System.out.println("Başarıyla Çıkış Yapıldı");
        System.exit(0);
    }

    public DevicesPersistenceMenuApp(String path) throws IOException{
        m_devicesFile = new RandomAccessFile(path,"rw");
    }

    public void run() {

        for(;;){

            try{
                this.displayMenu();
                this.doWorkForOption(Integer.parseInt(m_scan.nextLine()));
            }

            catch (NumberFormatException ignore){
                System.out.println("Seçenekler [1,3] aralığında olmalıdır");
            }

            catch (Throwable ignore){
                System.out.println("Beklenmedik Bir Sorun Oluştu");
            }

        }
    }

    public void close() throws IOException{
        m_devicesFile.close();
    }
}