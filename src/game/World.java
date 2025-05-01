package game;

import core.Main;
import game.managers.CardManager;
import game.managers.EntityManager;
import game.managers.MessageManager;
import game.messages.FloatMessage;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import resources.Images;

public class World {
    private static int round;
    private final CardManager cardManager;
    private final EntityManager entityManager;

    private static String gameStage;
    private static Image background;

    private static StateBasedGame sbg;

    public World(GameContainer gc, StateBasedGame sbg) {
        World.sbg = sbg;

        entityManager = new EntityManager();
        cardManager = new CardManager(gc);
        gameStage = "My Turn";
        background = Images.HAPPYBACKGROUND;
        round = 1;

        cardManager.setEntityManager(entityManager);
    }

    public void addNewCard() {
        CardManager.addNewCard();
    }


    public void addNewRelic() {
        entityManager.addNewRelic();
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
        updateBackground();
        CardManager.update();
        entityManager.update();
        if(entityManager.enemyAnimationsFinished() && isEnemyTurn()) {
            endTurn();
            startMyTurn();
        }
        gameEnd();
//        System.out.println(gameStage);
    }

    public void render(Graphics g) {
        g.drawImage(background.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight()),0, 0);
        CardManager.render(g);
        entityManager.render(g);
        drawButton(g);
    }
    public void mousePressed(int button, int x, int y){
        cardManager.mousePressed(button, x, y);
        endTurnButton(button, x, y);
    }
    public void mouseReleased(int button, int x, int y){
        cardManager.mouseReleased(button, x, y);
    }
    public void gameEnd(){
        if(entityManager.isPlayerDead()){
            gameStage = "end";
        }
    }
    public String getGameStage(){
        return gameStage;
    }
    public void resetWorld(){
        cardManager.resetManager();
        entityManager.resetManager();
        gameStage = "My Turn";
        background = Images.CREEPYBACKGROUND;
        round = 1;
    }
    public static int getRound(){
        return round;
    }
    public static void nextRound(){
        round++;
        CardManager.resetHand();
        CardManager.resetEnergy();
        sbg.enterState(Main.WIN_ID);
    }
    public void endTurnButton(int button, int x, int y){
        int width = (int) (Main.getScreenWidth() * 0.1);
        int height = (int) (Main.getScreenHeight() * 0.1);
        int buttonX = Main.getScreenWidth() - width;
        int buttonY = Main.getScreenHeight() - height;
        if(x > buttonX && x < buttonX + width && y > buttonY && y < buttonY + height){
            if(button == 0){
                if(isMyTurn()) {
                    startEnemyTurn();
                    System.out.println("wsg");
                }
            }
        }
    }
    public void drawButton(Graphics g){
        int width = (int) (Main.getScreenWidth() * 0.1);
        int height = (int) (Main.getScreenHeight() * 0.1);
        int buttonX = Main.getScreenWidth() - width;
        int buttonY = Main.getScreenHeight() - height;
        if (round < 15) {
            g.drawImage(Images.NORMAL_ENDTURN.getScaledCopy(width, height), buttonX, buttonY);
        }

        if (round == 15)
        {
            g.drawImage(Images.BOSS_ENDTURN.getScaledCopy(width, height), buttonX, buttonY);
        }

        g.setLineWidth(4);
        g.drawRect(buttonX, buttonY, width, height);
        g.setLineWidth(1);
    }
    public void updateBackground(){
        if(round % 5 == 0){
            background = Images.CREEPYBACKGROUND.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
        }
        else {
            background = Images.HAPPYBACKGROUND.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
        }
    }

    public void renderRound(Graphics g) {
        g.drawString("Round " + round, Main.getScreenWidth()/100f, Main.getScreenHeight()/75f);
    }
    public void killeverything(){
        entityManager.killEverything();
    }
}
