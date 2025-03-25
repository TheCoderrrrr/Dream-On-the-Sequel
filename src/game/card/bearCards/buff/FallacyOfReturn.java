package game.card.bearCards.buff;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class FallacyOfReturn extends Card implements SingleTarget {
    public FallacyOfReturn()
    {
        super();
        cardImage = Images.FALLACY_RETURN;
        energyCost = 0;
        name = "Fallacy of Return";
        description = "Increase dmg by 20 for 3 rounds";

    }
    public void use(Entity owner, Entity e) {

    }
}
