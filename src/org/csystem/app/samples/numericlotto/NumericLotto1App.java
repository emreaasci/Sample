package org.csystem.app.samples.numericlotto;

import org.csystem.util.ArrayUtil;

import java.util.Random;
import java.util.Scanner;

public class NumericLotto1App {
    public static void run(){
        Scanner scan = new Scanner(System.in);
        NumericLotto1 lotto1 = new NumericLotto1();

        for(;;){
            System.out.print("kac lotto yaratmak istiyorsunuz:");
            int n = Integer.parseInt(scan.nextLine());

            if(n <= 0)
                break;

            for(int i = 0;i < n;i++){
                ArrayUtil.display(2,lotto1.getNumbers());
            }
        }
    }
}
