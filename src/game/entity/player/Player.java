package game.entity.player;

import core.Main;
import game.artifacts.Artifact;
import game.artifacts.Bulwark;
import game.artifacts.ManaStone;
import game.effects.Effect;
import game.entity.Entity;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Fonts;
import resources.Images;

import java.util.ArrayList;

public class Player extends Entity {
    public static final int PLAYER_MAX_HP = 100;
    private ArrayList<Artifact> artifacts;
    private ArrayList<Artifact> addableArtifacts;

    public Player() {
        super(PLAYER_MAX_HP);
        artifacts = new ArrayList<>();
        addableArtifacts = new ArrayList<>();

        addableArtifacts.add(new Bulwark());
        addableArtifacts.add(new ManaStone());
        image = Images.BEAR_HERO;
    }

    @Override
    public void action() {

    }

    public void addNewRelic() {
        if(!addableArtifacts.isEmpty()) {
            Artifact a = addableArtifacts.get((int) (Math.random() * addableArtifacts.size()));

            addableArtifacts.remove(a);
            artifacts.add(a);
        }
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

        renderHealth(g, x, y);
    }
    public void renderHealth(Graphics g, int x, int y){
        if(image != null){
            float barWidth = (float) (image.getWidth() * 1.5);
            g.setColor(Color.black);
            g.fillRect((float) (x - barWidth / 5), (float) (y + image.getHeight() * 0.75),barWidth, (float) (Main.getScreenHeight() * 0.012));
            g.setColor(Color.red);
            g.fillRect((float) (x - barWidth / 5), (float) (y + image.getHeight() * 0.75), barWidth * getPercentHealthLeft(), (float) (Main.getScreenHeight() * 0.012));
            g.setColor(Color.white);
            Fonts.REGULAR.drawStringCentered(g , health + " / " + maxHealth, (float) x + image.getWidth() / 2, (float) (y + image.getHeight() * 0.78), 22);

            //ik this looks stupid to put in here but its so much easier
            effectsPanel.render(g, (int) (x - barWidth / 5), (int) (y + image.getHeight() * 0.84));
        }
    }
}
