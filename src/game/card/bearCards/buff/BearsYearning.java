package game.card.bearCards.buff;

import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class BearsYearning extends Card implements SingleTarget {
    public BearsYearning()
    {
        super();
        energyCost = 3;
        name = "Bear's Yearning";
        description = "Completely block next attack";
        cardImage = Images.BEARS_YEARNING;
    }


    public void use(Entity owner, Entity e) {

    }
}
