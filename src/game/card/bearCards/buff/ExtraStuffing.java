package game.card.bearCards.buff;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;


public class ExtraStuffing extends Card implements SingleTarget {
    public ExtraStuffing()
    {
        super();
        cardImage = Images.EXTRA_STUFFING;
        energyCost = 0;
        name = "Extra Stuffing";
        description = "Reduce incoming dmg by 25%";
    }

    public void use(Entity e) {

    }
}
