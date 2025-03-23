package game.effects;

import game.entity.Entity;

/// instant damage
public class Damage extends Effect{
    private final int damage;

    public Damage(Entity owner, Entity target, int damage) {
        super(1);
        this.damage = damage;
        name = "";
        description = "";
    }

    @Override
    public void action() {
        target.takeDamage(damage);
        durationLeft--;
    }
}
