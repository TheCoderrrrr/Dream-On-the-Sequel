package game.effects;

import game.entity.Entity;
import resources.Images;
import resources.Sounds;

public class Shield extends Effect{
    private final float multiplier;

    public Shield(float amount, int duration) {
        super(duration);
        this.multiplier = amount;
        name = "Shield";
        symbol = Images.SHIELD;
        description = "Increases block percentage.";
    }

    public Shield copy() {
        return new Shield(multiplier, duration);
    }

    @Override
    public void apply() {
        Sounds.SHIELD.play(1f, .5f);
        target.modifyBlock(multiplier);
        durationLeft--;
    }
}
