package game.card.bearCards.mutli.attack;

import game.card.Attacking;
import game.card.Card;
import game.card.MultiTarget;
import game.entity.Entity;
import resources.Images;

public class ThreadTornado extends Card implements MultiTarget, Attacking {
    public ThreadTornado()
    {
        super();
        energyCost = 1;
        name = "Thread Tornado";
        description = "25 dmg to all enemies";
        cardImage = Images.THREAD_TORNADO;
    }

    public void use(Entity owner) {

    }
}
