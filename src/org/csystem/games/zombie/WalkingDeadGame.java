package org.csystem.games.zombie;

import org.csystem.games.template.AbstractGame;

public class WalkingDeadGame extends AbstractGame {


    public WalkingDeadGame() {
        super("Walking Dead Game");
    }

    public void init() {
        System.out.println("WalkingDead.init");
    }


    public void play() {
        System.out.println("WalkingDead.play");
    }

    public void pause() {
        System.out.println("WalkingDead.pause");
    }

    public void save() {
        System.out.println("WalkingDead.save");
    }

    public void load() {
        System.out.println("WalkingDead.load");
    }

    public void destruct() {
        System.out.println("WalkingDead.destruct");
    }
}
