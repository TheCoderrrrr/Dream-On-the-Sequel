package game.card.bearCards.buff;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class PrimalRage extends Card implements SingleTarget {
    public PrimalRage()
    {
        super();
        cardImage = Images.PRIMAL_RAGE;
        energyCost = 1;
        name = "Primal Rage";
        description = "Increase Dmg by 30% for a round";
    }

    public void use(Entity e) {

    }
}
