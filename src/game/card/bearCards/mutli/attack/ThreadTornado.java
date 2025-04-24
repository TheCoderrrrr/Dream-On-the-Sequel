package game.card.bearCards.mutli.attack;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.MultiTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.entity.Entity;
import game.managers.EntityManager;
import game.managers.HitBox;
import game.ui.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class ThreadTornado extends Card implements MultiTarget, Attacking {
    public ThreadTornado()
    {
        super();
        energyCost = 1;
        name = "Thread Tornado";
        description = "25 dmg to all enemies";
        cardImage = Images.THREAD_TORNADO;
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(25));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);
    }

    public void use(Entity owner) {
        for(HitBox hitBox : EntityManager.getHitBoxes()){
            if(hitBox.hasEntity()){
                for(Effect effect : action.getEffects()) {
                    effect.setOwner(owner);
                    effect.setTarget(hitBox.getEntity());
                }
                for(Effect effect : action.getEffects()) {
                    effect.apply();
                }
            }
        }

    }
}
