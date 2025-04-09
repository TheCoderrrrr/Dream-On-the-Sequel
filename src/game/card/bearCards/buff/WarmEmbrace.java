package game.card.bearCards.buff;
import game.actions.Action;
import game.card.Buffing;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.effects.Heal;
import game.managers.EntityManager;
import game.ui.EffectsPanel;
import resources.Images;
import game.entity.Entity;

import java.util.ArrayList;

public class WarmEmbrace extends Card implements SingleTarget, Buffing {
    public WarmEmbrace()
    {
        super();
        cardImage = Images.WARM_EMBRACE;
        energyCost = 1;
        name = "Warm Embrace";
        description = "Heal 15 HP for the next 2 rounds";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Heal(15, 20));
        action = new Action(actions);
        effectsPanel = new EffectsPanel(actions);
    }

    public void use(Entity owner, Entity e) {
        for(Effect effect : action.getEffects()) {
            effect.setOwner(EntityManager.getPlayer());
            effect.setTarget(EntityManager.getPlayer());
        }
        for(Effect effect : action.getEffects()) {
            effect.apply();
        }
    }
}
