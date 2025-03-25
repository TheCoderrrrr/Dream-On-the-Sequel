package game.effects;

import game.entity.Entity;
import resources.Images;

public class Heal extends Effect{
    private final int healStrength;

    public Heal(int healStrength, int duration) {
        super(duration);
        this.healStrength = healStrength;
        name = "Healing";
        symbol = Images.HEALING;
        description = "Restores health to the player.";
    }

    @Override
    public void apply() {
        target.heal(healStrength);
        durationLeft--;
    }
}
