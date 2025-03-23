package game.effects;

import game.entity.Entity;

public class Burn extends Effect {
    private final int BURN_STRENGTH;

    public Burn(Entity owner, Entity target, int burnStrength, int duration)
    {
        super(duration);
        BURN_STRENGTH = burnStrength;
    }

    @Override
    public void action() {

    }
}
