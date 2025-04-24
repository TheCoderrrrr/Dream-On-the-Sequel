package game.card.bearCards.single.attack;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.entity.Entity;
import game.ui.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class PawPummel extends Card implements SingleTarget, Attacking {
    public PawPummel(){
        super();
        energyCost = 1;
        name = "Paw Pummel";
        cardImage = Images.PAW_PUMMEL;
        description = "25 dmg to selected target";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(25));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);

    }

    public void use(Entity owner, Entity e) {
        for(Effect effect : action.getEffects()) {
            effect.setOwner(owner);
            effect.setTarget(e);
        }
        for(Effect effect : action.getEffects()) {
            effect.apply();
        }

    }
}