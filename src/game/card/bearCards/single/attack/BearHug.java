package game.card.bearCards.single.attack;

import game.card.Card;
import game.card.SingleTarget;
import game.effects.Effect;
import game.entity.Entity;
import resources.Images;

public class BearHug extends Card implements SingleTarget{
    public BearHug(){
        super();
        energyCost = 2;
        name = "Bear Hug";
        cardImage = Images.BEAR_HUG;
        description = "20 dmg to selected target and applies vulnerable effect";

    }

    public void use(Entity owner, Entity e) {

    }
}