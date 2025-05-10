package game.card.bearCards.single.attack;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.effects.Mark;
import game.entity.Entity;
import game.ui.panels.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class Slam extends Card implements SingleTarget, Attacking {
    public Slam(){
        super();
        energyCost = 1;
        name = "Slam";
        cardImage = Images.SLAM;
        description = "20 dmg to selected target and mark effect";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(20));
        actions.add(new Mark(1.5f, 1));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);
    }

    @Override
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