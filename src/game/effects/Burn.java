package game.effects;

import game.entity.Entity;
import game.managers.HitBox;
import game.managers.MessageManager;
import game.messages.FloatMessage;
import org.newdawn.slick.Color;
import resources.Images;
import resources.Sounds;

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
        Sounds.BURN.play(1f, .5f);
        if(target.getMyHitBox() != null){
            HitBox h = target.getMyHitBox();
            MessageManager.addMessage(new FloatMessage(String.valueOf(burnStrength), (float) (h.getX() + h.getWidth() * Math.random()), (float) h.getY(), Color.orange, 60));
        }
    }
}
