package game;

import game.managers.CardManager;
import game.managers.EntityManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class World {

    private final CardManager cardManager;
    private final EntityManager entityManager;

    private static String gameStage;

    public World(GameContainer gc) {
        cardManager = new CardManager(gc);
        entityManager = new EntityManager();
        gameStage = "My Turn";
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

    public void update() {
        cardManager.update();
        entityManager.update();
        if(entityManager.enemyAnimationsFinished()) {
            startMyTurn();
        }
    }

    public void render(Graphics g) {
        cardManager.render(g);
        entityManager.render(g);
    }

}
