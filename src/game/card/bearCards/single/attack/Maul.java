package game.card.bearCards.single.attack;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.entity.Entity;
import game.ui.panels.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class Maul extends Card implements SingleTarget, Attacking {
    public Maul(){
        super();
        energyCost = 2;
        name = "Maul";
        cardImage = Images.MAUL;
        description = "30 dmg to selected target";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(30));
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