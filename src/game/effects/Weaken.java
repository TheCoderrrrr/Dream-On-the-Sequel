package game.effects;

import resources.Images;
import resources.Sounds;

public class Weaken extends Effect{
    private float multiplier;
    public Weaken(float multiplier, int duration) {
        super(duration);
        this.multiplier = multiplier;
        name = "Weakened";
        symbol = Images.WEAKENED;
        description = "Reduces the damage the enemy deals to the player.";
    }

    public Weaken copy() {
        return new Weaken(multiplier, duration);
    }

    @Override
    public void apply() {
        Sounds.WEAKEN.play(1f, .5f);
        durationLeft--;
    }
}
