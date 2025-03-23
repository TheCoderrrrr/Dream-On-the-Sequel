package game.card.bearCards.single.attack;

import game.card.Card;
import game.card.SingleTarget;
import game.entity.Entity;
import resources.Images;

public class PawCrush extends Card implements SingleTarget{
    public PawCrush(){
        super();
        energyCost = 2;
        name = "Paw Crush";
        cardImage = Images.PAW_CRUSH;
        description = "50 dmg to selected target and burn effect applied";

    }

    public void use(Entity e) {

    }
}