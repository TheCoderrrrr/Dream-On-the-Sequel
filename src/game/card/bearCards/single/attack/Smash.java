package game.card.bearCards.single.attack;

import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class Smash extends Card implements SingleTarget{
    public Smash(){
        super();
        energyCost = 1;
        name = "Smash";
        cardImage = Images.SMASH;
        description = "25 dmg to selected target";

    }

    public void use(Entity owner, Entity e) {

    }
}
