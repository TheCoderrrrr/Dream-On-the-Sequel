package game.effects;

import game.entity.Entity;
import resources.Images;
import resources.Sounds;

public class Strength extends Effect{
    private final float attackMultiplier;

    public Strength(float attackMultiplier, int duration) {
        super(duration);
        this.attackMultiplier = attackMultiplier;
        name = "StrengthBoost";
        symbol = Images.STRENGTH;
        description = "Temporarily increases the damage of the attacks.";
    }

    public Strength copy() {
        return new Strength(attackMultiplier, duration);
    }

    @Override
    public void apply() {
        Sounds.STRENGTH.play();
        target.modifyAttack(attackMultiplier);
        durationLeft--;
    }
}
