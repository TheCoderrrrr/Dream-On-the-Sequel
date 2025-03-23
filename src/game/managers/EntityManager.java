package game.managers;

import game.World;
import game.entity.Entity;
import game.entity.player.Player;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> enemies;
    private Player player;

    private int currEntityAnimationID;
    private boolean enemyTurnFinished;

    public EntityManager() {
        enemies = new ArrayList<>();
        player = new Player();
    }

    public void myTurn() {
        player.action();
    }

    public void enemyTurn() {
        currEntityAnimationID = 0;
        enemyTurnFinished = false;
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
}
