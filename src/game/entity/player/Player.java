package game.entity.player;

import game.artifacts.Artifact;
import game.artifacts.Bulwark;
import game.artifacts.ManaStone;
import game.effects.Effect;
import game.entity.Entity;
import org.newdawn.slick.Graphics;
import resources.Fonts;
import resources.Images;

import java.util.ArrayList;

public class Player extends Entity {
    public static final int PLAYER_MAX_HP = 100;
    private ArrayList<Artifact> artifacts;

    public Player() {
        super(PLAYER_MAX_HP);
        artifacts = new ArrayList<>();
        artifacts.add(new Bulwark());
        artifacts.add(new ManaStone());
        image = Images.BEAR_HERO;
    }

    @Override
    public void action() {

    }

    @Override
    public void newTurn() {
        for(Artifact a : artifacts) {
            a.turnStartEffects(this);
        }
    }

    public void takeDamage(int damage) {
        for(Artifact a : artifacts) {
            a.damageTakenEffect(this);
        }

        if(Math.random() < blockPercent) {
            //block damage
            return;
        }

        int damageTaken = (int) ((float) damage * defenseMultiplier); //account for defense

        health -= damageTaken;
        health = Math.max(0, health); //if hp < 0, set hp to 0


    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x, y);
        Fonts.REGULAR.drawString(g , "Hp : " + health + " ", (float) x, (float) y+20, 25);
        Fonts.REGULAR.drawString(g, blockPercent + ": block", x, y+40, 25);

        int e = 800;
        for(Artifact a : artifacts) {
            g.drawString(a.toString(), 100, e);
            e += 50;
        }

        e = 800;
        for(Effect effect : activeEffects) {
            g.drawString(effect.getClass().getSimpleName() + " duration: " + effect.getDurationLeft(), 500, e);
            e += 50;
        }
    }
}
