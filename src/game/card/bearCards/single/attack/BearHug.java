package game.card.bearCards.single.attack;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.effects.Vulnerable;
import game.entity.Entity;
import resources.Images;

import java.util.ArrayList;

public class BearHug extends Card implements SingleTarget, Attacking {
    public BearHug(){
        super();
        energyCost = 2;
        name = "Bear Hug";
        cardImage = Images.BEAR_HUG;
        description = "20 dmg to selected target and applies vulnerable effect";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(20));
        actions.add(new Vulnerable(1.5f, 3));
        action = new Action(actions);
    }

    public void use(Entity owner, Entity target) {
        for(Effect effect : action.getEffects()) {
            effect.setOwner(owner);
            effect.setTarget(target);
        }
        for(Effect effect : action.getEffects()) {
            effect.apply();
        }
    }
}