package game.entity.player;

import game.entity.Entity;

public class Player extends Entity {
    public static final int PLAYER_MAX_HP = 100;

    public Player() {
        super(PLAYER_MAX_HP);
    }

    @Override
    public void action() {

    }
}
