package game.managers;

import core.Main;
import game.World;
import game.entity.Entity;
import game.entity.TestEnemy;
import game.entity.player.Player;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> enemies;
    private Player player;

    private int currEntityAnimationID;
    private boolean enemyTurnFinished;

    public EntityManager() {
        enemies = new ArrayList<>();
        player = new Player();

        enemies.add(new TestEnemy());
        enemies.add(new TestEnemy());
        enemies.add(new TestEnemy());
    }

    public void myTurn() {
        player.action();
    }

    public void enemyTurn() {
        currEntityAnimationID = 0;
        enemyTurnFinished = false;
    }

    public boolean enemyAnimationsFinished() {
        return enemyTurnFinished;
    }

    public void update() {
        if(World.isEnemyTurn()) {
            if(currEntityAnimationID < enemies.size()) {
                //make sure we stay within array bounds

                if(enemies.get(currEntityAnimationID).finishedAnimation()) {
                    //if the current enemy finished the animation, then call action() for that enemy

                    enemies.get(currEntityAnimationID).action();

                    //then, move to the next enemy
                    enemies.get(currEntityAnimationID).resetAnimation();
                    currEntityAnimationID++;

                } else {

                    //otherwise, move to the next frame within the enemy animation
                    enemies.get(currEntityAnimationID).nextAnimationFrame();
                }
            } else {

                enemyTurnFinished = true;

            }

        }
    }
    
    public void endTurn() {
        player.endTurn();
        for(Entity e : enemies) {
            e.endTurn();
        }
    }

    public void render(Graphics g) {
        for(int i = 0; i < enemies.size(); i++){
            Entity enemy = enemies.get(i);
            enemy.render(g, (int) (Main.getScreenWidth() * .75 + (i % 2 == 0 ? 0 : Main.getScreenWidth() * .1)), (int) (Main.getScreenHeight() * .5));
        }
    }
}
