package game.effects;

import game.entity.Entity;
import resources.Images;

public class Strength extends Effect{
    private final float attackMultiplier;

    public Strength(Entity owner, Entity target, float attackMultiplier, int duration) {
        super(duration);
        this.attackMultiplier = attackMultiplier;
        name = "StrengthBoost";
        symbol = Images.STRENGTH;
        description = "Temporarily increases the damage of the attacks.";
    }

    @Override
    public void action() {
        target.modifyAttack(attackMultiplier);
        durationLeft--;
    }
}
