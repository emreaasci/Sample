package org.csystem.app.samples.device;

import java.util.Scanner;

public final class StoreDevicesToArrayApp {

    private StoreDevicesToArrayApp(){

    }

    private static Device [] enlarge(Device [] devices,int newCapacity){

        Device [] result = new Device[newCapacity];

        for(int i = 0;i < devices.length;i++){
            result[i] = devices[i];
        }

        return result;

    }

    public static void run() {
        Scanner scan=  new Scanner(System.in);
        System.out.print("kaç elemanlı:");

        Device [] devices = new Device[Integer.parseInt(scan.nextLine())];
        int index = 0;

        for(;;) {
            System.out.print("Cihaz adını giriniz:");
            String name =  scan.nextLine();

            if(name.equals("elma"))
                break;

            System.out.print("Cihaz IP giriniz:");
            String host = scan.nextLine();

            System.out.print("Cihaz port numarasını giriniz:");
            int port = Integer.parseInt(scan.nextLine());

            if(index == devices.length)
                devices = enlarge(devices,devices.length * 2);


            devices[index++] = new Device(name,host,port);

            System.out.printf("Size:%d%n",index);
            System.out.printf("Capacity:%d%n",devices.length);
        }

        System.out.println("---------------------");
        for(int i = 0;i < index;i++)
            System.out.println(devices[i].toString());


        System.out.printf("Size:%d%n",index);
        System.out.printf("Capacity:%d%n",devices.length);
    }

}
