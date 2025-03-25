package game.card.bearCards.buff;
import game.card.Card;
import game.card.SingleTarget;
import resources.Images;
import game.entity.Entity;

public class Sewing extends Card implements SingleTarget {
    public Sewing()
    {
        super();
        cardImage = Images.SEWING;
        energyCost = 3;
        name = "Sewing";
        description = "Heal 30 HP";
    }

    public void use(Entity owner, Entity e) {

    }

}
