package game.effects;

import resources.Images;
import resources.Sounds;

public class Harden extends Effect{
    private final float multiplier;

    public Harden(float amount, int duration) {
        super(duration);
        this.multiplier = amount;
        name = "Shield";
        symbol = Images.SHIELD;
        description = "Decreases Damage Taken";
    }

    public Harden copy() {
        return new Harden(multiplier, duration);
    }

    @Override
    public void apply() {
        Sounds.SHIELD.play(1f, .5f);
        target.modifyDefense(multiplier);
        durationLeft--;
    }
}
