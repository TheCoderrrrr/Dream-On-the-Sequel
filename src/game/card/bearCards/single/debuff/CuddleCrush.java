package game.card.bearCards.single.debuff;
import game.card.Attacking;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class CuddleCrush extends Card implements SingleTarget, Attacking {
    public CuddleCrush()
    {
        super();
        energyCost = 1;
        name = "Cuddle Crush";
        cardImage = Images.CUDDLE_CRUSH;
        description = "Applies Mark Effect";

    }

    public void use(Entity owner, Entity e) {

    }
}
