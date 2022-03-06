package Homeworks.Java002.ornek4;

import java.util.Scanner;

/* 4. Klavyeden bir height ve width değişkenleri için sayılar okuyunuz ve aşağıdaki deseni oluşturunuz:
						|*   |
                        | *  |
						|  * |
						|   *|
						|  * |
						| *  |
						|*   |
						| *  |
*/

public class main {
    public static void main(String[] argv) {
        BallFallGameApp.play();
    }
}

class BallFallGameApp{
    public static void play() {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.print("width = ");
        int width = Integer.parseInt(scan.nextLine());
        System.out.print("height = ");
        int height = Integer.parseInt(scan.nextLine());

        BallFallGame.play(width, height);

    }
}

class BallFallGame{
    public static void fillSpace(int begin,int end) {

        for(int i = begin;i < end;i++) {
            System.out.print(' ');
        }
    }

    public static void fillBall(int ballIndex,int end){

        fillSpace(0,ballIndex);
        System.out.print('*');
        fillSpace(ballIndex + 1,end);

    }

    public static boolean updateRightFlag(int ballIndex,boolean isRight , int widht) {
        if(ballIndex == 0)
            isRight = true;
        else if(ballIndex == widht - 1)
            isRight = false;

        return isRight;

    }

    public static void play(int width,int height) {
        int ballIndex = 0;
        boolean isRight = true;

        for(int i = 1;i <= height;i++) {
            System.out.print('|');
            fillBall(ballIndex,width);
            isRight = updateRightFlag(ballIndex,isRight,width);
            if(width != 1) {
                if(isRight)
                    ++ballIndex;
                else
                    --ballIndex;
            }

            System.out.println('|');
        }
    }
}