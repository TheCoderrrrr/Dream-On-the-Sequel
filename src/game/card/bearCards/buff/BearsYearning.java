package game.card.bearCards.buff;

import game.actions.Action;
import game.card.Buffing;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Effect;
import game.effects.Heal;
import game.effects.Shield;
import game.entity.Entity;
import game.ui.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class BearsYearning extends Card implements SingleTarget, Buffing {
    public BearsYearning()
    {
        super();
        energyCost = 3;
        name = "Bear's Yearning";
        description = "Completely block next attack";
        cardImage = Images.BEARS_YEARNING;
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Shield(1, 1));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);
    }


    public void use(Entity owner, Entity e) {
        action.action(owner, e);
    }
}
