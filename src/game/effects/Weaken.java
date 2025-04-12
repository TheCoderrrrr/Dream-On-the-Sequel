package game.effects;

import resources.Images;

public class Weaken extends Effect{
    private float multiplier;
    public Weaken(float multiplier, int duration) {
        super(duration);
        this.multiplier = multiplier;
        name = "Weakened";
        symbol = Images.WEAKENED;
        description = "Reduces the damage the enemy deals to the player.";
    }

    public float getMultiplier() {
        if (multiplier == 1) {
            return .1f;
        } else if (multiplier == 2) {
            return .2f;
        } else if (multiplier == 3) {
            return .4f;
        } else {
            return .5f;
        }
    }

    @Override
    public void apply() {
        durationLeft--;
    }
}
