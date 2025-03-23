package game.card.bearCards.buff;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class PlushPerfection extends Card implements SingleTarget {
    public PlushPerfection()
    {
        super();
        cardImage = Images.PLUSH_PERFECTION;
        energyCost = 2;
        name = "Plush Perfection";
        description = "Heal 30 HP";
    }

    public void use(Entity e) {

    }
}
