package org.csystem.application.birthdayremainder;

import org.csystem.util.Console;

public class BirthDayRemainderApp {
    private static BirthDayRemainder getBirthDAyRemainder(){
        Console.writeLine("Lütfen doğum günü bilgilerini giriniz");
        var day = Console.readInt("Gün:");

        if(day <= 0)
            return null;

        var mount = Console.readInt("Ay:");
        var year = Console.readInt("Yıl:");


        return new BirthDayRemainder(day,mount,year);

    }

    private BirthDayRemainderApp(){
    }

    public static void run(){
        for(;;){
            var birthDateInfo = getBirthDAyRemainder();

            if(birthDateInfo == null)
                break;

            String message = "";

            switch (birthDateInfo.getBirthDayStatus()){
                case AFTER:
                    message = "doğum gününüz henüz gelmedi";
                    break;
                case BEFORE:
                    message = "geçmiş doğum gününüz kutlu olsun";
                    break;
                case SAME:
                    message = "doğum gününüz kutlu olsun";
                    break;
            }

            System.out.print(message);
        }
    }



}
