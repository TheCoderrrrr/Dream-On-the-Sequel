package game.card.bearCards.single.attack;

import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class PawPummel extends Card implements SingleTarget{
    public PawPummel(){
        super();
        energyCost = 1;
        name = "Paw Pummel";
        cardImage = Images.PAW_PUMMEL;
        description = "25 dmg to selected target";

    }

    public void use(Entity owner, Entity e) {

    }
}