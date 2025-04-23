package game.effects;

import game.entity.Entity;
import game.managers.HitBox;
import game.managers.MessageManager;
import game.messages.FloatMessage;
import org.newdawn.slick.Color;
import resources.Images;
import resources.Sounds;

public class Poison extends Effect {
    private final int poisonStrength;


    public Poison(int poisonStrength, int duration) {
        super(duration);
        this.poisonStrength = poisonStrength;
        name = "Poisoned";
        symbol = Images.POISONED;
        description = "Deals " + poisonStrength + " damage every round for " + duration + " rounds.";
    }

    public Poison copy() {
        return new Poison(poisonStrength, duration);
    }

    @Override
    public void apply() {
        Sounds.POISON.play(1f, .5f);
        target.takeDamage(poisonStrength);
        if(target.getMyHitBox() != null){
            HitBox h = target.getMyHitBox();
            MessageManager.addMessage(new FloatMessage(String.valueOf(poisonStrength), (float) (h.getX() + h.getWidth() * Math.random()), (float) h.getY(), Color.green, 60));
        }
        durationLeft--;
    }
}
