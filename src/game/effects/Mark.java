package game.effects;

import resources.Images;

public class Mark extends Effect{
    private float multiplier;

    public Mark(float multiplier, int duration) {
        super(duration);
        this.multiplier = multiplier;
        name = "Marked";
        symbol = Images.MARKED;
        description = "Makes the affected enemy take additional damage when attacked.";
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
    public void action() {

    }
}
