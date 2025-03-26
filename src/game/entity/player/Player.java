package game.entity.player;

import game.artifacts.Artifact;
import game.entity.Entity;
import org.newdawn.slick.Graphics;
import resources.Images;

import java.util.ArrayList;

public class Player extends Entity {
    public static final int PLAYER_MAX_HP = 100;
    private static ArrayList<Artifact> artifacts;

    public Player() {
        super(PLAYER_MAX_HP);
        artifacts = new ArrayList<>();
        image = Images.BEAR_HERO;
    }

    @Override
    public void action() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x, y);
        g.drawString(health + " ", x, y+20);
    }
}
