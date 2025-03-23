package game.card.bearCards.single.debuff;
import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class StitchedSilence extends Card implements SingleTarget {
    public StitchedSilence()
    {
        super();
        energyCost = 1;
        name = "Stitched Silence";
        cardImage = Images.STITCHED_SILENCE;
        description = "Decrease enemy attack by 10%";
    }

    public void use(Entity e) {

    }
}
