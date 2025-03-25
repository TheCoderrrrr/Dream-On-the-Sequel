package game.effects;

import game.entity.Entity;

/// instant damage
public class Damage extends Effect{
    private final int damage;

    public Damage(int damage) {
        super(1);
        this.damage = damage;
        name = "";
        description = "";
    }

    @Override
    public void apply() {
        target.takeDamage(damage);
        durationLeft--;
    }
}
