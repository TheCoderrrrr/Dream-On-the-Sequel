package game;

import core.Main;
import game.managers.CardManager;
import game.managers.EntityManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import resources.Images;

public class World {
    private static int round;
    private final CardManager cardManager;
    private final EntityManager entityManager;

    private static String gameStage;
    private static Image background;

    public World(GameContainer gc) {
        cardManager = new CardManager(gc);
        entityManager = new EntityManager();
        gameStage = "My Turn";
        background = Images.CREEPYBACKGROUND;
        round = 1;


        cardManager.setEntityManager(entityManager);
    }

    public void keyPressed(int key, char c) {
        if(key == Input.KEY_SPACE) {
            if(isMyTurn()) {
                startEnemyTurn();
            }
        }
    }

    public static boolean isMyTurn() {
        return gameStage.equals("My Turn");
    }
    public static boolean isEnemyTurn() {
        return gameStage.equals("Enemy Turn");
    }

    public void startMyTurn() {
        gameStage = "My Turn";
        entityManager.myTurn();
    }

    public void startEnemyTurn() {
        gameStage = "Enemy Turn";
        entityManager.enemyTurn();
    }

    public void endTurn() {
        entityManager.endTurn();
    }

    public void update() {
        CardManager.update();
        entityManager.update();
        if(entityManager.enemyAnimationsFinished()) {
            endTurn();
            startMyTurn();
        }
    }

    public void render(Graphics g) {
        g.drawImage(background.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight()),0, 0);
        CardManager.render(g);
        entityManager.render(g);
    }
    public void mousePressed(int button, int x, int y){
        cardManager.mousePressed(button, x, y);
    }
    public void mouseReleased(int button, int x, int y){
        cardManager.mouseReleased(button, x, y);
    }

}
