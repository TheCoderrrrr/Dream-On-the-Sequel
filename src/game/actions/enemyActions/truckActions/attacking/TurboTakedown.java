package game.actions.enemyActions.truckActions.attacking;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;


public class TurboTakedown extends Action {
    public TurboTakedown()
    {
        super(new ArrayList<>(List.of(new Damage(45))));
        description = "Does 45 damage";
    }
}
