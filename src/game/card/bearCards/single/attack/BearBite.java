package game.card.bearCards.single.attack;

import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class BearBite extends Card implements SingleTarget{
    public BearBite(){
        super();
        energyCost = 1;
        name = "Bear Bite";
        cardImage = Images.BEAR_BITE;
        description = "25 dmg to selected target";

    }

    public void use(Entity e) {

    }
}