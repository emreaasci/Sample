package org.csystem.games.template;

import org.csystem.games.ballfall.BallFallGame;
import org.csystem.games.craps.CrapsGame;
import org.csystem.games.zombie.WalkingDeadGame;

public class GameRunnerApp {
    private GameController m_controller;

    private void initGames() {
        m_controller.add(new WalkingDeadGame());
        m_controller.add(new BallFallGame());
        m_controller.add(new CrapsGame());

    }

    public GameRunnerApp() {
        m_controller = new GameController();
        this.initGames();
    }

    public void run() {
        m_controller.run();
    }
}
