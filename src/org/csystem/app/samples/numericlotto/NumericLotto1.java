package org.csystem.app.samples.numericlotto;

import java.util.Arrays;
import java.util.Random;

public class NumericLotto1 {
    public Random random;

    public NumericLotto1(){
        random = new Random();
    }

    public NumericLotto1(Random r){
        random = r;
    }

    public int[] getNumbers(){
        int [] numbers = new int[6];

        for(int i = 0;i < 6;i++){
            boolean repeat;

            do{
                repeat = false;
                numbers[i] = random.nextInt(49)+1;
                for(int k = 0;k < i;k++){
                    if(numbers[k] == numbers[i]){
                        repeat = true;
                        break;
                    }
                }

            }while(repeat);
        }

        Arrays.sort(numbers);
        return numbers;
    }
}
