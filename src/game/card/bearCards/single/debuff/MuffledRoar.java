package game.card.bearCards.single.debuff;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class MuffledRoar extends Card implements SingleTarget {
    public MuffledRoar()
    {
        super();
        energyCost = 1;
        name = "Muffled Roar";
        cardImage = Images.MUFFLED_ROAR;
        description = "Applies Vulnerability";
        energyCostImage = Images.ENERGY1;

    }

    public void use(Entity e) {

    }
}
