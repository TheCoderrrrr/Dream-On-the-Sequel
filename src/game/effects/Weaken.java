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
        description = "Reduces damage taken.";
    }

    public Weaken copy() {
        return new Weaken(multiplier, duration);
    }

    @Override
    public void apply() {
        target.modifyAttack(multiplier);
        Sounds.WEAKEN.play(1f, .5f);
        durationLeft--;
    }
}
