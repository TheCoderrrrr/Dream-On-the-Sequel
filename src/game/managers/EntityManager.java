package game.managers;

import core.Main;
import game.World;
import game.card.Card;
import game.entity.Entity;
import game.entity.TestEnemy;
import game.entity.enemy.Enemy;
import game.entity.player.Player;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Entity> enemies;
    private final ArrayList<HitBox> hitBoxes;
    private Player player;

    private int currEntityAnimationID;
    private boolean enemyTurnFinished;

    public EntityManager() {
        enemies = new ArrayList<>();
        player = new Player();

        hitBoxes = new ArrayList<>();
        for(int i=0; i<3; i++) {
            hitBoxes.add(new HitBox((int) (Main.getScreenWidth()*0.75f + i * Main.getScreenWidth()/12f), Main.getScreenHeight()/2));
        }
        for(int i=0; i<2; i++) {
            hitBoxes.add(new HitBox((int) (Main.getScreenWidth()*0.80f + i * Main.getScreenWidth()/12f), Main.getScreenHeight()/2 - Main.getScreenHeight()/10));
        }

        for(HitBox h : hitBoxes) {
            h.setPlayer(player);
        }
        addEnemy(new TestEnemy());
        addEnemy(new TestEnemy());
        addEnemy(new TestEnemy());


    }
    public void addEnemy(Enemy e) {
        for(HitBox h : hitBoxes) {
            if(!h.hasEnemy()) {
                h.setEnemy(e);
                enemies.add(e);
                return;
            }
        }
    }

    public void myTurn() {
        player.action();
    }
    public void enemyTurn() {
        currEntityAnimationID = 0;
        enemyTurnFinished = false;
    }
    public void endTurn() {
        player.endTurn();
        for(Entity e : enemies) {
            e.endTurn();
        }
    }

    public boolean enemyAnimationsFinished() {
        return enemyTurnFinished;
    }

    public void cardReleased(Card c, int x, int y) {
        for(HitBox h : hitBoxes) {
            if(h.isMouseOver(x, y) && h.hasEnemy()) {
                h.useCard(c);
            }
        }
    }


    public void update() {
        if(World.isEnemyTurn()) {
            if(currEntityAnimationID < hitBoxes.size()) {
                //make sure we stay within array bounds

                HitBox currHitBox = hitBoxes.get(currEntityAnimationID);
                if(currHitBox.hasEnemy() && currHitBox.getEnemy().finishedAnimation()) {
                    //if the current enemy finished the animation, then call action() for that enemy

                    if(currHitBox.hasEnemy()) {
                        currHitBox.getEnemy().action();

                        //then, move to the next enemy
                        currHitBox.getEnemy().resetAnimation();
                    }

                    currEntityAnimationID++;

                } else {

                    //otherwise, move to the next frame within the enemy animation
                    currHitBox.getEnemy().nextAnimationFrame();
                }
            } else {

                enemyTurnFinished = true;

            }

        }
        for(HitBox hitBox : hitBoxes){
            hitBox.chroma();
        }
    }

    public void render(Graphics g) {
        for(HitBox hitbox : hitBoxes){
            hitbox.render(g);
        }
    }
}
