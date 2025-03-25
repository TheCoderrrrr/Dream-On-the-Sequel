package game.card.bearCards.mutli.debuff;

import game.card.Card;
import game.card.MultiTarget;
import game.entity.Entity;
import resources.Images;

public class ButtonBomb extends Card implements MultiTarget {
    public ButtonBomb()
    {
        super();
        energyCost = 2;
        name = "Button Bomb";
        description = "Adds Mark Effect";
        cardImage = Images.BUTTON_BOMB;
    }

    public void use(Entity owner)
    {

    }
}
