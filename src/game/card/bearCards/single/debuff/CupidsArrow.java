package game.card.bearCards.single.debuff;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class CupidsArrow extends Card implements SingleTarget {
    public CupidsArrow()
    {
        super();
        energyCost = 3;
        name = "Cupid's Arrow";
        cardImage = Images.CUPIDS_ARROW;
        description = "Decrease Enemy Attack by 10%";

    }

    public void use(Entity owner, Entity e) {

    }
}
