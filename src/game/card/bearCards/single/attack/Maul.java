package game.card.bearCards.single.attack;

import game.card.Card;
import game.card.SingleTarget;
import game.effects.Effect;
import game.entity.Entity;
import resources.Images;

public class Maul extends Card implements SingleTarget{
    public Maul(){
        super();
        energyCost = 2;
        name = "Maul";
        cardImage = Images.MAUL;
        description = "30 dmg to selected target";


    }


    public void use(Entity owner, Entity e) {

    }
}