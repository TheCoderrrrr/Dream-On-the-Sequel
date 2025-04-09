package game.card.bearCards.mutli.debuff;

import game.card.Attacking;
import game.card.Card;
import game.card.MultiTarget;
import game.entity.Entity;
import resources.Images;

public class ComfortCurse extends Card implements MultiTarget, Attacking {
    public ComfortCurse()
    {
        super();
        energyCost = 2;
        name = "Comfort Curse";
        description = "Adds Vulnerability";
        cardImage = Images.COMFORT_CURSE;

    }

    public void use(Entity owner)
    {

    }
}
