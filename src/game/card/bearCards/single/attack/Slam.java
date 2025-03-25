package game.card.bearCards.single.attack;

import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class Slam extends Card implements SingleTarget{
    public Slam(){
        super();
        energyCost = 1;
        name = "Slam";
        cardImage = Images.SLAM;
        description = "20 dmg to selected target and mark effect";

    }

    @Override
    public void use(Entity owner, Entity e) {

    }
}