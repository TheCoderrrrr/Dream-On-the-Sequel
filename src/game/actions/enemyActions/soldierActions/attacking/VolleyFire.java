package game.actions.enemyActions.soldierActions.attacking;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class VolleyFire extends Action {
    public VolleyFire()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage";
    }
}
