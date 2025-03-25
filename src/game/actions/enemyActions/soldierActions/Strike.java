package game.actions.enemyActions.soldierActions;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class Strike extends Action {
    public Strike()
    {
        super(new ArrayList<>(List.of(new Damage(10))));
        description = "Does 10 damage";
    }
}
