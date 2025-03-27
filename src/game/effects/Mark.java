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

    @Override
    public void apply() {
        target.modifyDefense(multiplier);
        durationLeft--;
    }
}
