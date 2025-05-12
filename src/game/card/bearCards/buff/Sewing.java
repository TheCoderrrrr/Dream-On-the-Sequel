package game.card.bearCards.buff;
import game.actions.Action;
import game.card.Buffing;
import game.card.Card;
import game.card.SingleTarget;
import game.effects.Effect;
import game.effects.Heal;
import game.ui.panels.CardEffectsPanel;
import resources.Images;
import game.entity.Entity;

import java.util.ArrayList;

public class Sewing extends Card implements SingleTarget, Buffing {
    public Sewing()
    {
        super();
        cardImage = Images.SEWING;
        energyCost = 2;
        name = "Sewing";
        description = "Heal 30 HP";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Heal(30, 1));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);
    }

    public void use(Entity owner, Entity e) {
        action.action(owner, e);

    }

}
