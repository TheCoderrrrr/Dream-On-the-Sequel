package game.actions.enemyActions.ballActions.buffing;

import game.actions.Action;
import game.actions.Buffing;
import game.effects.Damage;
import game.effects.Heal;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class BounceBack extends Action implements Buffing {
    public BounceBack()
    {
        super(new ArrayList<>(List.of(new Heal(20, 1))));
        description = "Heals 20 HP for 1 round";
        symbol = Images.ACTION_HEAL;
    }
}
