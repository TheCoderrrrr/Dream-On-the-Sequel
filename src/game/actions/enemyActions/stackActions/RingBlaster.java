package game.actions.enemyActions.stackActions;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class RingBlaster extends Action {
    public RingBlaster()
    {
        super(new ArrayList<>(List.of(new Damage(30))));
        description = "Does 30 damage";
    }
}
