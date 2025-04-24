package game.actions.enemyActions.stackActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class RingBlaster extends Action implements Attacking {
    public RingBlaster()
    {
        super(new ArrayList<>(List.of(new Damage(30))));
        description = "Does 30 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
