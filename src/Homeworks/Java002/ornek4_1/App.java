package Homeworks.Java002.ornek4_1;

public class App {
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

        BallFallGame ballfallgame = new BallFallGame();

        ballfallgame.play(width, height);

        System.out.print(ballfallgame.shape);

    }
}

class BallFallGame{
    public String shape = "";

    public static boolean updateRightFlag(int ballIndex,boolean isRight , int widht) {
        if(ballIndex == 0)
            isRight = true;
        else if(ballIndex == widht - 1)
            isRight = false;

        return isRight;

    }

    public void fillSpace(int begin,int end) {

        for(int i = begin;i < end;i++) {
            shape += ' ';
        }
    }

    public void fillBall(int ballIndex,int end){

        fillSpace(0,ballIndex);
        shape += '*';
        fillSpace(ballIndex + 1,end);

    }


    public void play(int width,int height) {
        int ballIndex = 0;
        boolean isRight = true;

        for(int i = 1;i <= height;i++) {
            shape += "|";
            fillBall(ballIndex,width);
            isRight = updateRightFlag(ballIndex,isRight,width);
            if(width != 1) {
                if(isRight)
                    ++ballIndex;
                else
                    --ballIndex;
            }

            shape += "|\n";
        }
    }
}