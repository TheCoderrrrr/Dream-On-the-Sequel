package game.card.bearCards.single.debuff;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class CuddleCrush extends Card implements SingleTarget {
    public CuddleCrush()
    {
        super();
        energyCost = 1;
        name = "Cuddle Crush";
        cardImage = Images.CUDDLE_CRUSH;
        description = "Applies Mark Effect";

    }

    public void use(Entity e) {

    }
}
