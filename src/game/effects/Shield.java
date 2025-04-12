package game.effects;

import game.entity.Entity;
import resources.Images;

public class Shield extends Effect{
    private final float multiplier;

    public Shield(float amount, int duration) {
        super(duration);
        this.multiplier = amount;
        name = "Shield";
        symbol = Images.SHIELD;
        description = "Increases block percentage.";
    }

    @Override
    public void apply() {
        target.modifyBlock(multiplier);
        durationLeft--;
    }
}
