package game.card.bearCards.single.attack;

import game.actions.Action;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.entity.Entity;
import game.ui.EffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class BearBite extends Card implements SingleTarget{
    public BearBite(){
        super();
        energyCost = 1;
        name = "Bear Bite";
        cardImage = Images.BEAR_BITE;
        description = "25 dmg to selected target";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(25));
        action = new Action(actions);
        effectsPanel = new EffectsPanel(actions);
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