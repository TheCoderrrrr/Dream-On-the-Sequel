package game.effects;

import game.entity.Entity;
import resources.Images;

public class Burn extends Effect {
    private final int BURN_STRENGTH;

    public Burn(int burnStrength, int duration)
    {
        super(duration);
        BURN_STRENGTH = burnStrength;
        name = "IM ON FIRE";
        symbol = Images.HEALING;
        description = "AHHHHHHH IM ON FIRE";
    }

    @Override
    public void apply() {
        target.heal(BURN_STRENGTH);
        durationLeft--;
    }
}
