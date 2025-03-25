package game.actions.enemyActions.truckActions;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class RamSlam extends Action {
    public RamSlam()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage";
    }
}
