package game.card.bearCards.mutli.debuff;

import game.card.Attacking;
import game.card.Card;
import game.card.MultiTarget;
import game.entity.Entity;
import resources.Images;



public class StuffedSorrow extends Card implements MultiTarget, Attacking {
    public StuffedSorrow()
    {
        super();
        energyCost = 3;
        name = "Stuffed Sorrow";
        description = "Decrease Enemy Attack by 20% for 1 round";
        cardImage = Images.STUFFED_SORROW;
    }

    public void use(Entity owner)
    {

    }

}
