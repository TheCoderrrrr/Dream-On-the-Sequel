package game.card.bearCards.buff;
import game.actions.Action;
import game.card.Buffing;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Effect;
import game.effects.Strength;
import game.entity.Entity;
import game.ui.panels.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class PrimalRage extends Card implements SingleTarget, Buffing {
    public PrimalRage()
    {
        super();
        cardImage = Images.PRIMAL_RAGE;
        energyCost = 1;
        name = "Primal Rage";
        description = "Increase Dmg by 30% for a round";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Strength(1.3f, 1));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);

    }

    public void use(Entity owner, Entity e) {
        action.action(owner, e);

    }
}
