package game.card.bearCards.single.attack;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.effects.Poison;
import game.entity.Entity;
import game.ui.panels.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class ConcealedClaws extends Card implements SingleTarget, Attacking {
    public ConcealedClaws(){
        super();
        energyCost = 4;
        name = "Concealed Claws";
        cardImage = Images.CONCEALED_CLAWS;
        description = "Deals 75 damage and inflicts poison (-25 HP from self)";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(75));
        actions.add(new Poison(10, 3));
        ArrayList<Effect> self = new ArrayList<>();
        self.add(new Damage(25));
        action = new Action(actions);
        selfDamaging = new Action(self);
        if(!selfDamaging.getEffects().isEmpty()){
            actions.addAll(self);
        }
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
        for(Effect effect : selfDamaging.getEffects()){
            effect.setOwner(owner);
            effect.setTarget(owner);
        }
        for(Effect effect : selfDamaging.getEffects()){
            effect.apply();
        }
    }
}