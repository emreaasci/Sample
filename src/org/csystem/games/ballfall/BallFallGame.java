package org.csystem.games.ballfall;

import org.csystem.games.template.AbstractGame;

import java.util.Scanner;

public class BallFallGame extends AbstractGame {

    private BallFall m_ballFallGame;
    public Scanner m_scan;

    public BallFallGame() {
        super("Ball Fall Game");
    }

    public void init() {
        m_ballFallGame = new BallFall();
        m_scan = new Scanner(System.in);
    }

    public void play() {
        for (;;) {
            System.out.print("Width?");
            int width = Integer.parseInt(m_scan.nextLine());

            if (width <= 0)
                break;

            System.out.print("Height?");
            int height = Integer.parseInt(m_scan.nextLine());

            m_ballFallGame.play(width, height);

            System.out.println(m_ballFallGame.shape);
            System.out.println("//////////////////////");
        }
    }

    public void pause() {
        System.out.println("Ball Fall Game.pause");
    }

    public void save() {
        System.out.println("Ball Fall Game.save");
    }

    public void load() {
        System.out.println("Ball Fall Game.load");
    }

    public void destruct() {
        System.out.println("Ball Fall Game.destruct");
    }
}
