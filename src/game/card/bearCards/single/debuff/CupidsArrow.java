package game.card.bearCards.single.debuff;
import game.card.Attacking;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class CupidsArrow extends Card implements SingleTarget, Attacking {
    public CupidsArrow()
    {
        super();
        energyCost = 1;
        name = "Cupid's Arrow";
        cardImage = Images.CUPIDS_ARROW;
        description = "Decrease Enemy Attack by 10%";

    }

    public void use(Entity owner, Entity e) {

    }
}
