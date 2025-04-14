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
        target.takeDamage(damage);
        durationLeft--;

        for (HitBox h : EntityManager.getHitBoxes())
        {
            if(h.getEnemy() == target)
            {
                MessageManager.addMessage(new FloatMessage(String.valueOf(damage), h.getX(), h.getY(), Color.red, 60));
                System.out.println("Adding float message for damage: " + damage);
                System.out.println(h.getY());
            }
        }
    }

    public String toString()
    {
        return "-" + damage;
    }
    public int getDamage(){
        return damage;
    }
}
