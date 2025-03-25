package game.card.bearCards.mutli.attack;

import game.card.Card;
import game.card.MultiTarget;
import game.entity.Entity;
import resources.Images;

public class ButtonBarrage extends Card implements MultiTarget {
    public ButtonBarrage()
    {
        super();
        energyCost = 1;
        name = "Button Barrage";
        cardImage = Images.BUTTON_BARRAGE;
        description = "Attacks with buttons among 3 enemies";

    }
    public void use(Entity owner) {

    }
}
