package game.managers;

import core.Main;
import game.World;
import game.card.Attacking;
import game.card.Card;
import game.entity.TestEnemy;
import game.entity.enemy.Entity;
import game.entity.player.Player;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class EntityManager {
    private ArrayList<game.entity.Entity> enemies;
    private static ArrayList<HitBox> hitBoxes;
    private static ArrayList<HitBox> hitBoxesInUse;
    private static Player player;
    private static HitBox playerHitBox;
    private int currEntityAnimationID;
    private int numOfEntityAnimationID;
    private boolean enemyTurnFinished;

    public EntityManager() {
        enemies = new ArrayList<>();
        player = new Player();

        hitBoxes = new ArrayList<>();
        hitBoxesInUse = new ArrayList<>();
        playerHitBox = new HitBox((int) (Main.getScreenWidth()*0.25f), Main.getScreenHeight()/2);

        for(int i=0; i<3; i++) {
            hitBoxes.add(new HitBox((int) (Main.getScreenWidth()*0.75f + i * Main.getScreenWidth()/12f), Main.getScreenHeight()/2));
        }
        for(int i=0; i<2; i++) {
            hitBoxes.add(new HitBox((int) (Main.getScreenWidth()*0.80f + i * Main.getScreenWidth()/12f), Main.getScreenHeight()/2 - Main.getScreenHeight()/10));
        }

        for(HitBox h : hitBoxes) {
            h.setPlayer(player);
        }

        playerHitBox.setEntity(player);
        playerHitBox.setPlayer(player);

        addEnemy(new TestEnemy());
        addEnemy(new TestEnemy());
        addEnemy(new TestEnemy());
    }
    public void addEnemy(Entity e) {
        for(HitBox h : hitBoxes) {
            if(!h.hasEntity()) {
                h.setEntity(e);
                enemies.add(e);
                e.initializeTarget(player);
                e.assignHitBox(h);
                return;
            }
        }
    }

    public void myTurn() {
        player.action();
    }
    public void enemyTurn() {
        currEntityAnimationID = 0;
        numOfEntityAnimationID = 0;
        for(HitBox hitBox : hitBoxes){
            if(hitBox.hasEntity()){
                hitBoxesInUse.add(hitBox);
                numOfEntityAnimationID++;
            }
        }
        enemyTurnFinished = false;
    }
    public void endTurn() {
        for(game.entity.Entity e : enemies) {
            e.endTurn();
        }
        player.endTurn();
    }

    public boolean enemyAnimationsFinished() {
        return enemyTurnFinished;
    }

    public void cardReleased(Card c, int x, int y) {
        if(c instanceof Attacking){
            for(HitBox h : hitBoxes) {
                if(h.isMouseOver(x, y) && h.hasEntity()) {
                    h.useCard(c);
                }
            }
        }else{
            if(playerHitBox.isMouseOver(x, y) && playerHitBox.hasEntity()){
                playerHitBox.useCard(c);
            }
        }
    }


    public void update() {

        if(World.isEnemyTurn()) {
            if(currEntityAnimationID < numOfEntityAnimationID) {
                //make sure we stay within array bounds

                HitBox currHitBox = hitBoxesInUse.get(currEntityAnimationID);
                if(currHitBox.hasEntity()) {
                    if(currHitBox.getEntity().finishedAnimation()){
                        //if the current enemy finished the animation, then call action() for that enemy

                        if(currHitBox.hasEntity()) {
                            currHitBox.getEntity().action();
                            //then, move to the next enemy
                            currHitBox.getEntity().resetAnimation();
                        }

                        currEntityAnimationID++;
                    }else{
                        //otherwise, move to the next frame within the enemy animation
                        if(currHitBox.hasEntity()) currHitBox.getEntity().nextAnimationFrame();
                    }
                } else {
                    numOfEntityAnimationID++;
                }
            } else {

                enemyTurnFinished = true;
                CardManager.resetHand();
                CardManager.resetEnergy();
            }

        }
        for(HitBox hitBox : hitBoxes){
            hitBox.chroma();
        }
        cleanUp();
        newRound();
    }
    public void cleanUp(){
        for(int i = hitBoxes.size() - 1; i >= 0; i--)
        {
            if(hitBoxes.get(i).hasEntity() && hitBoxes.get(i).getEntity().isDead()){
                hitBoxes.get(i).killEntity();
                hitBoxesInUse.remove(hitBoxes.get(i));
            }
        }
    }
    public boolean isPlayerDead(){
        return player.isDead();
    }

    public void render(Graphics g) {
        player.render(g, (int) (Main.getScreenWidth() * .25), Main.getScreenHeight() / 2);
        for(HitBox hitbox : hitBoxes){
            hitbox.render(g);
        }
    }
    public void resetManager(){
        enemies.clear();
        player = new Player();

        hitBoxes.clear();
        hitBoxesInUse.clear();
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
    public void newRound(){
        if(isAllEnemiesDead()){
            World.nextRound();
            CardManager.resetEnergy();
            addEnemy(new TestEnemy());
            addEnemy(new TestEnemy());
            addEnemy(new TestEnemy());
        }
    }
    private boolean isAllEnemiesDead(){
        for(HitBox hitBox : hitBoxes){
            if(hitBox.hasEntity()) return false;
        }
        return true;
    }
    public static ArrayList<HitBox> getHitBoxes(){
        return hitBoxes;
    }
    public static HitBox getPlayerHitBox(){
        return playerHitBox;
    }
}
