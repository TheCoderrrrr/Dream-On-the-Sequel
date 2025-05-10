package game.managers;

import core.Game;
import core.Main;
import game.World;
import game.artifacts.Artifact;
import game.card.Attacking;
import game.card.Card;
import game.effects.Effect;
import game.effects.Shield;
import game.entity.TestEnemy;
import game.entity.enemy.Enemy;
import game.entity.enemy.Horse;
import game.entity.enemy.Rocket;
import game.entity.enemy.Soldier;
import game.entity.enemy.boss.Godzilla;
import game.entity.enemy.miniboss.*;
import game.entity.player.Player;
import game.ui.panels.RoundEndPanel;
import org.newdawn.slick.GameContainer;
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
    private RoundEndPanel roundEndPanel;
    private GameContainer gc;

    public EntityManager(GameContainer gc) {
        enemies = new ArrayList<>();
        player = new Player();

        hitBoxes = new ArrayList<>();
        hitBoxesInUse = new ArrayList<>();
        playerHitBox = new HitBox((int) (Main.getScreenWidth() * 0.25f), (int) (Main.getScreenHeight() / 2.2));

        for (int i = 0; i < 3; i++) {
            hitBoxes.add(new HitBox((int) (Main.getScreenWidth() * 0.75f + i * Main.getScreenWidth() / 12f), (int) (Main.getScreenHeight() / 2.2)));
        }
        for (int i = 0; i < 2; i++) {
            hitBoxes.add(new HitBox((int) (Main.getScreenWidth() * 0.80f + i * Main.getScreenWidth() / 12f), Main.getScreenHeight() / 2 - Main.getScreenHeight() / 10));
        }

        for (HitBox h : hitBoxes) {
            h.setPlayer(player);
        }

        playerHitBox.setEntity(player);
        playerHitBox.setPlayer(player);
        player.assignHitBox(playerHitBox);

        addEnemy(new Horse());
//        addEnemy(new Stack(100));
//        addEnemy(new Godzilla(200));
//        addEnemy(new TestEnemy());
        this.gc = gc;
    }

    public void addEnemy(Enemy e) {
        for (HitBox h : hitBoxes) {
            if (!h.hasEntity()) {
                h.setEntity(e);
                enemies.add(e);
                e.initializeTarget(player);
                e.assignHitBox(h);
                return;
            }
        }
    }

    public Artifact addNewRelic() {
        return player.addNewRelic();
    }

    public void myTurn() {
        player.action();
    }

    public void enemyTurn() {
        currEntityAnimationID = 0;
        numOfEntityAnimationID = 0;
        for (HitBox hitBox : hitBoxes) {
            if (hitBox.hasEntity()) {
                hitBoxesInUse.add(hitBox);
                numOfEntityAnimationID++;
            }
        }
        enemyTurnFinished = false;
    }

    public void endTurn() {
        for (game.entity.Entity e : enemies) {
            e.endTurn();
        }
        player.endTurn();
    }

    public boolean enemyAnimationsFinished() {
        return enemyTurnFinished;
    }

    public void cardReleased(Card c, int x, int y) {
        if (c instanceof Attacking) {
            for (HitBox h : hitBoxes) {
                if (h.isMouseOver(x, y) && h.hasEntity()) {
                    h.useCard(c);
                }
            }
        } else {
            if (playerHitBox.isMouseOver(x, y) && playerHitBox.hasEntity()) {
                playerHitBox.useCard(c);
            }
        }
    }


    public void update() {

        if (World.isEnemyTurn()) {
            if (currEntityAnimationID < numOfEntityAnimationID) {
                //make sure we stay within array bounds

                HitBox currHitBox = hitBoxesInUse.get(currEntityAnimationID);
                if (currHitBox.hasEntity()) {
                    if (currHitBox.getEntity().finishedAnimation()) {
                        //if the current enemy finished the animation, then call action() for that enemy

                        if (currHitBox.hasEntity()) {
                            currHitBox.getEntity().action();

                            //then, move to the next enemy
                            currHitBox.getEntity().resetAnimation();
                        }

                        currEntityAnimationID++;
                    } else {
                        //otherwise, move to the next frame within the enemy animation
                        if (currHitBox.hasEntity()) currHitBox.getEntity().nextAnimationFrame();
                    }
                } else {
                    currEntityAnimationID++;
                }
            } else {

                enemyTurnFinished = true;
                CardManager.resetHand();
                CardManager.resetEnergy();
                player.newTurn();
            }

        }
        for (HitBox hitBox : hitBoxes) {
            hitBox.chroma();
        }
        cleanUp();
//        newRound();
        if(isAllEnemiesDead() && roundEndPanel == null){
            if(World.getRound() == 5 || World.getRound() == 10){
                roundEndPanel = new RoundEndPanel(gc, true, true, this);
            }else{
                roundEndPanel = new RoundEndPanel(gc, false, true, this);
            }
        }
    }

    public void cleanUp() {
        for (int i = hitBoxes.size() - 1; i >= 0; i--) {
            if (hitBoxes.get(i).hasEntity() && hitBoxes.get(i).getEntity().isDead()) {
                hitBoxes.get(i).killEntity();
                hitBoxesInUse.remove(hitBoxes.get(i));
            }
        }
    }

    public boolean isPlayerDead() {
        return player.isDead();
    }

    public void render(Graphics g) {
        playerHitBox.render(g);
        for (HitBox hitbox : hitBoxes) {
            hitbox.render(g);
        }
        if(roundEndPanel != null){
            roundEndPanel.render(g);
        }
    }

    public void resetManager() {
        enemies.clear();
        player = new Player();

        playerHitBox.setEntity(player);
        playerHitBox.setPlayer(player);
        player.assignHitBox(playerHitBox);

        hitBoxes.clear();
        hitBoxesInUse.clear();
        for (int i = 0; i < 3; i++) {
            hitBoxes.add(new HitBox((int) (Main.getScreenWidth() * 0.75f + i * Main.getScreenWidth() / 12f), Main.getScreenHeight() / 2));
        }
        for (int i = 0; i < 2; i++) {
            hitBoxes.add(new HitBox((int) (Main.getScreenWidth() * 0.80f + i * Main.getScreenWidth() / 12f), Main.getScreenHeight() / 2 - Main.getScreenHeight() / 10));
        }
        for (HitBox h : hitBoxes) {
            h.setPlayer(player);
        }
        addEnemy(new Horse());
    }

    public void newRound() {
        if (isAllEnemiesDead()) {
            World.nextRound();
            CardManager.resetEnergy();
            player.newTurn();
            roundEndPanel = null;
            switch (World.getRound()) {
                case 2:
                    addEnemy(new Horse());
                    addEnemy(new Soldier());
                    break;
                case 3:
                    addEnemy(new Soldier());
                    addEnemy(new Rocket());
                    break;
                case 4:
                    addEnemy(new Duck());
                    addEnemy(new Soldier());
                    addEnemy(new Rocket());
                    break;
                case 5:
                    addEnemy(new Rocket());
                    addEnemy(new Truck());
                    addEnemy(new Stack());
                    break;
                case 6:
                    addEnemy(new Rocket());
                    addEnemy(new Jack());
                    break;
                case 7:
                    addEnemy(new Doll());
                    break;
                case 8:
                    addEnemy(new Doll());
                    addEnemy(new Duck());
                    break;
                case 9:
                    addEnemy(new Doll());
                    addEnemy(new Truck());
                    addEnemy(new Jack());
                    break;
                case 10:
                    addEnemy(new Doll());
                    addEnemy(new Duck());
                    addEnemy(new Jack());
                    break;
                case 11:
                    addEnemy(new Doll());
                    addEnemy(new Rocket());
                    addEnemy(new Jack());
                    break;
                case 12:
                    addEnemy(new Jack());
                    addEnemy(new Doll());
                    addEnemy(new Duck());
                    break;
                case 13:
                    addEnemy(new Duck());
                    addEnemy(new Doll());
                    addEnemy(new Doll());
                    break;
                case 14:
                    addEnemy(new Doll());
                    addEnemy(new Jack());
                    break;
                case 15:
                    addEnemy(new Godzilla());
                    break;
            }
        }
    }

    private boolean isAllEnemiesDead() {
        for (HitBox hitBox : hitBoxes) {
            if (hitBox.hasEntity()) return false;
        }
        return true;
    }

    public static ArrayList<HitBox> getHitBoxes() {
        return hitBoxes;
    }

    public static HitBox getPlayerHitBox() {
        return playerHitBox;
    }

    public void killEverything() {
        for (int i = hitBoxes.size() - 1; i >= 0; i--) {
            hitBoxes.get(i).killEntity();
            hitBoxesInUse.remove(hitBoxes.get(i));

        }
    }
    public void mousePressed(int button, int x, int y){
        if(roundEndPanel != null){
            roundEndPanel.mousePressed(button, x, y);
        }
    }
}
