package Homeworks.Java007.ornek2;
/* . Çağrıldığında ekrana 01.01.1900 ve 31.12.2100 arasında rastgele bir tarihi yazan printRandomDate isimli
metodu yazınız. Metodun ekrana yazdırdığı tarih geçerli bir tarih olmalıdır. Rasgele tarihin Şubat ayına denk
gelmesi durumunda, seçilen yılın artık yıl olup olmamasına göre, Şubat ayı 29 çekebilecektir. Tarih ekrana
aşağıdaki formatta yazdırılacaktır:
11th Jul 1983
*/

import org.csystem.app.samples.date.DateUtil;

import java.util.Random;


public class App {
    public static void main(String[] argv){
        RandomDate date1 = new RandomDate();

        date1.getRandomDate();
    }
}

class RandomDate {
    public Random r;
    public static String [] mounts = {"" , "Jun","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};


    public RandomDate(){
        r = new Random();
    }

    public void getRandomDate(){
        int year = r.nextInt(2100 - 1900 + 1) + 1900;  // 2100 dahil olduğu için +1
        int mount = r.nextInt(12) + 1;
        int day = r.nextInt(28) + 1;
        if(DateUtil.isLeapYear(year))
            day = r.nextInt(29) + 1;

        displayDate(day,mount,year);
    }

    public void displayDate(int day,int mount,int year){
        System.out.printf("%d%s %s %d",day,daySuffix(day),mounts[mount],year);
    }

    public String daySuffix(int day){

        String suffix = "th";

        switch (day){
            case 1:
            case 21:
            case 31:
                suffix = "st";
            case 2:
            case 22:
                suffix = "nd";
            case 3:
            case 23:
                suffix = "rd";
        }

        return suffix;
    }
}


