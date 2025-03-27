package game.card.bearCards.mutli.attack;

import game.actions.Action;
import game.card.Card;
import game.card.MultiTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.entity.Entity;
import game.managers.EntityManager;
import game.managers.HitBox;
import resources.Images;

import java.util.ArrayList;

public class NeedleToss extends Card implements MultiTarget {
    public NeedleToss()
    {
        super();
        energyCost = 2;
        name = "Needle Toss";
        description = "20 dmg to all enemies";
        cardImage = Images.NEEDLE_TOSS;
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(20));
        action = new Action(actions);
    }

    public void use(Entity owner)
    {
        for(HitBox hitBox : EntityManager.getHitBoxes()){
            if(hitBox.hasEnemy()){
                for(Effect effect : action.getEffects()) {
                    effect.setOwner(owner);
                    effect.setTarget(hitBox.getEnemy());
                }
                for(Effect effect : action.getEffects()) {
                    effect.apply();
                }
            }
        }
    }
}
