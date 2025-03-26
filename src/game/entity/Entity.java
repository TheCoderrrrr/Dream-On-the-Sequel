package game.entity;

import game.effects.Effect;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import java.util.ArrayList;

public abstract class Entity {
    protected ArrayList<Effect> activeEffects;
    protected int health;
    protected int maxHealth;
    protected float attackMultiplier;
    protected float blockPercent;
    protected float defenseMultiplier;
    protected int currAnimationFrame = 0;
    protected final int animationFrame = 15;
    protected Image image;
    protected boolean isdead;


    public Entity(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.defenseMultiplier = 1;
        this.attackMultiplier = 1;
        this.blockPercent = 0;
        activeEffects = new ArrayList<>();
        isdead = false;
    }

    abstract public void action(); //call this method only once per turn
    abstract public void render(Graphics g, int x, int y);

    public void update() {

    }

    public void endTurn() {
        attackMultiplier = 1;
        defenseMultiplier = 1;
        blockPercent = 0;


        for(Effect e : activeEffects) {
            e.apply();
        }

        for(int i=activeEffects.size()-1; i>=0; i--) {
            if(activeEffects.get(i).isExpired()) {
                activeEffects.remove(i);
            }
        }
    }

    public void newTurn() {

    }

    public void modifyAttack(float multiplier) {
        attackMultiplier *= multiplier;
    }

    public void modifyDefense(float multiplier) {
        defenseMultiplier *= multiplier;
    }

    public void modifyBlock(float multiplier) {
        blockPercent += (1 - blockPercent) * multiplier;
    }

    public final void takeDamage(int damage) {
        if(Math.random() < blockPercent) {
            //block damage
            return;
        }

        int damageTaken = (int) ((float) damage * defenseMultiplier); //account for defense

        health -= damageTaken;
        health = Math.max(0, health); //if hp < 0, set hp to 0
    }
    public final void heal(int heal) {
        health += heal;
        health = Math.min(health, maxHealth); //prevent overheal
    }

    public void resetAnimation() {
        currAnimationFrame = 0;
    }

    public void nextAnimationFrame() {
        currAnimationFrame++;
    }

    public boolean finishedAnimation() {
        return currAnimationFrame == animationFrame;
    }
    public boolean isDead(){
        return health == 0;
    }
}
