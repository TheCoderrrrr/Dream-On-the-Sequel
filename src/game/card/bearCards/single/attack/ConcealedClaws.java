package game.card.bearCards.single.attack;

import game.card.Card;
import game.card.SingleTarget;
import game.effects.Effect;
import game.entity.Entity;
import resources.Images;

public class ConcealedClaws extends Card implements SingleTarget{
    public ConcealedClaws(){
        super();
        energyCost = 4;
        name = "Concealed Claws";
        cardImage = Images.CONCEALED_CLAWS;

    }


    public void use(Entity owner, Entity e) {

    }
}