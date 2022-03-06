package org.csystem.games.template;

public abstract class AbstractGame {
    protected String name;
    public abstract void init();
    public abstract void play();
    public abstract void pause();
    public abstract void save();
    public abstract void load();
    public abstract void destruct();

    protected AbstractGame(String name){
        this.name = name;
    }

    public final void run(){
        this.init();
        this.load();
        this.play();
        //.....

        this.pause();
        this.save();
        this.destruct();
    }
}
