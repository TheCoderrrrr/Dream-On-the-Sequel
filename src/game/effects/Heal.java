package game.effects;

import resources.Images;
import resources.Sounds;

public class Heal extends Effect{
    private final int healStrength;

    public Heal(int healStrength, int duration) {
        super(duration);
        this.healStrength = healStrength;
        name = "Healing";
        symbol = Images.HEALING;
        description = "Restores health to the player.";
    }

    public Heal copy() {
        return new Heal(healStrength, duration);
    }

    @Override
    public void apply() {
        Sounds.HEALING.play();
        target.heal(healStrength);
        durationLeft--;
    }
}
