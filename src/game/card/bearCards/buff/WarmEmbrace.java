package game.card.bearCards.buff;
import game.card.Card;
import game.card.SingleTarget;
import resources.Images;
import game.entity.Entity;

public class WarmEmbrace extends Card implements SingleTarget {
    public WarmEmbrace()
    {
        super();
        cardImage = Images.WARM_EMBRACE;
        energyCost = 1;
        name = "Warm Embrace";
        description = "Heal 15 HP for the next 2 rounds";
    }

    public void use(Entity owner, Entity e) {

    }
}
