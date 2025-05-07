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

public class FallacyOfReturn extends Card implements SingleTarget, Buffing {
    public FallacyOfReturn()
    {
        super();
        cardImage = Images.FALLACY_RETURN;
        energyCost = 0;
        name = "Fallacy of Return";
        description = "Increase dmg by 20 for 3 rounds";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Strength(1.2f, 3));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);

    }
    public void use(Entity owner, Entity e) {
        action.action(owner, e);
    }
}
