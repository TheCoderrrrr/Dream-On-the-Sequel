package game.card.bearCards.single.attack;

import game.actions.Action;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Burn;
import game.effects.Damage;
import game.effects.Effect;
import game.entity.Entity;
import resources.Images;

import java.util.ArrayList;

public class PawCrush extends Card implements SingleTarget{
    public PawCrush(){
        super();
        energyCost = 2;
        name = "Paw Crush";
        cardImage = Images.PAW_CRUSH;
        description = "50 dmg to selected target and burn effect applied";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(50));
        actions.add(new Burn(10, 2));
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