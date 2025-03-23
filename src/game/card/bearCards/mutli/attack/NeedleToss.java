package game.card.bearCards.mutli.attack;

import game.card.Card;
import game.card.MultiTarget;
import resources.Images;

public class NeedleToss extends Card implements MultiTarget {
    public NeedleToss()
    {
        super();
        energyCost = 2;
        name = "Needle Toss";
        description = "20 dmg to all enemies";
        cardImage = Images.NEEDLE_TOSS;

    }

    public void use()
    {

    }
}
