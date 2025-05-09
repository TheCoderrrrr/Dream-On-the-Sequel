package game.effects;

import game.messages.FloatMessage;
import game.managers.MessageManager;
import game.managers.EntityManager;
import game.managers.HitBox;
import org.newdawn.slick.Color;

/// instant damage
public class Damage extends Effect {
    private final int damage;

    public Damage(int damage) {
        super(1);
        this.damage = damage;
        name = "";
        description = "";
    }

    public Damage copy() {
        return new Damage(damage);
    }

    @Override
    public void apply() {
        target.takeDamage((int) (damage * owner.getAttackMultiplier()));
        durationLeft--;

    }

    public String toString()
    {
        return "-" + damage;
    }
    public int getDamage(){
        return damage;
    }
}
