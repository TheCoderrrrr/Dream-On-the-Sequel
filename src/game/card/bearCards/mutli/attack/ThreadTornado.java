package game.card.bearCards.mutli.attack;

import game.card.Card;
import game.card.MultiTarget;
import resources.Images;

public class ThreadTornado extends Card implements MultiTarget {
    public ThreadTornado()
    {
        super();
        energyCost = 1;
        name = "Thread Tornado";
        description = "25 dmg to all enemies";
        cardImage = Images.THREAD_TORNADO;
    }

    public void use() {

    }
}
