package game.card.bearCards.buff;
import game.actions.Action;
import game.card.Buffing;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Effect;
import game.effects.Harden;
import game.effects.Heal;
import game.effects.Shield;
import game.entity.Entity;
import game.ui.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;


public class ExtraStuffing extends Card implements SingleTarget, Buffing {
    public ExtraStuffing()
    {
        super();
        cardImage = Images.EXTRA_STUFFING;
        energyCost = 0;
        name = "Extra Stuffing";
        description = "Reduce incoming dmg by 25%";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Harden(.75f, 1));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);
    }

    public void use(Entity owner, Entity e) {
        action.action(owner, e);

    }
}
