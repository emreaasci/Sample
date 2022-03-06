package Homeworks.Java011.ornek1;

import java.util.Random;

public class CentralLimitTheorem {
    private Random m_random;
    private int [] means;
    private int [] hist;

    public CentralLimitTheorem(){
        m_random = new Random();
        means = new int[5000];
        hist = new int[10];
        createHist();
    }


    public int CentralLimitMean(){
        int sum = 0;

        for(int i = 0;i < 5;i++){
            sum += (int) m_random.nextInt(10_001);
        }

        return sum / 5;
    }

    public void LimitMeans(){
        for(int i = 0;i < 5000;i++){
            means[i] = CentralLimitMean();
        }
    }


    public void createHist(){
        LimitMeans();
        for(int i = 0;i < 5000;i++){
            if(means[i] > 0 && means[i] <= 1000)
                hist[0]++;

            else if(means[i] > 1000 && means[i] < 2000)
                hist[1]++;

            else if(means[i] >= 2000 && means[i] < 3000)
                hist[2]++;

            else if(means[i] >= 3000 && means[i] < 4000)
                hist[3]++;

            else if(means[i] >= 4000 && means[i] < 5000)
                hist[4]++;

            else if(means[i] >= 5000 && means[i] < 6000)
                hist[5]++;

            else if(means[i] >= 6000 && means[i] < 7000)
                hist[6]++;

            else if(means[i] >= 7000 && means[i] < 8000)
                hist[7]++;

            else if(means[i] >= 8000 && means[i] < 9000)
                hist[8]++;

            else if(means[i] >= 9000 && means[i] < 10000)
                hist[9]++;

        }

    }

    public void printHist(){
        for(int i = 0;i < 10;i++){
            for(int k = 0;k < hist[i] / 5;k++)
                System.out.print("X");
            System.out.println();
        }

    }


}
