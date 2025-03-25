package game.entity.player;

import game.entity.Entity;
import org.newdawn.slick.Graphics;

public class Player extends Entity {
    public static final int PLAYER_MAX_HP = 100;

    public Player() {
        super(PLAYER_MAX_HP);
    }

    @Override
    public void action() {

    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawString("player", 1000, 0);
    }
}
