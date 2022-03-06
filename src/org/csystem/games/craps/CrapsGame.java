package org.csystem.games.craps;

import Homeworks.java015.ornek1.Card;
import org.csystem.games.template.AbstractGame;

import java.util.Scanner;

public class CrapsGame extends AbstractGame {
    private Craps m_craps;
    private Scanner m_scan;

    public CrapsGame() {
        super("Craps Game");
    }

    public void init() {
        m_craps =  new Craps();
        m_scan = new Scanner(System.in);
    }

    public void play() {
        System.out.print("Kaç kez oynamak istersiniz?");
        int n = Integer.parseInt(m_scan.nextLine());

        int count = 0;

        for (int i = 0; i < n; ++i) {
            m_craps.play();
            if (m_craps.isWin())
                ++count;
        }

        System.out.printf("p = %f%n", (double)count / n);
    }

    public void pause() {
        System.out.println("Craps Game.pause");
    }

    public void save() {
        System.out.println("Craps Game.save");
    }

    public void load() {
        System.out.println("Craps Game.load");
    }

    public void destruct() {
        System.out.println("Craps Game.destruct");
    }
}
