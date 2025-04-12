package game.effects;

import game.entity.Entity;
import resources.Images;

public class Burn extends Effect {
    private final int burnStrength;

    public Burn(int burnStrength, int duration)
    {
        super(duration);
        this.burnStrength = burnStrength;
        name = "IM ON FIRE";
        symbol = Images.HEALING;
        description = "AHHHHHHH IM ON FIRE";
    }

    public Burn copy() {
        return new Burn(burnStrength, duration);
    }

    @Override
    public void apply() {
        target.takeDamage(burnStrength);
        durationLeft--;
    }
}
