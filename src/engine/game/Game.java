package engine.game;

import engine.gui.GUI;
import engine.sound.SoundRegistry;

public class Game {

    public static void main(String[] args) {
        Game.getInstance().start();
    }

    private static Game _instance;

    public static Game getInstance(){
        if(_instance == null)_instance = new Game();
        return _instance;
    }

    private Scenario scenario;

    public Game() {}

    public void start(){
        scenario = new Scenario();
        java.awt.EventQueue.invokeLater(() -> {
            SoundRegistry.BACKGROUND_SOUND.play();
            new GUI().setVisible(true);
        });
    }

    public Scenario getScenario() {
        return scenario;
    }
}
