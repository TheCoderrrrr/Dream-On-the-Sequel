package game.effects;

import resources.Images;
import resources.Sounds;

public class Mark extends Effect{
    private float multiplier;

    public Mark(float multiplier, int duration) {
        super(duration);
        this.multiplier = multiplier;
        name = "Marked";
        symbol = Images.MARKED;
        description = "Makes the affected enemy take additional damage when attacked.";
    }

    public Mark copy() {
        return new Mark(multiplier, duration);
    }

    @Override
    public void apply() {
        Sounds.MARK.play(1f, .5f);
        target.modifyDefense(multiplier);
        durationLeft--;
    }
}
