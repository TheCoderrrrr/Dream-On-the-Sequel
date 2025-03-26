package game.actions.enemyActions.horseActions.attacking;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class NeighQuake extends Action {
    public NeighQuake()
    {
        super(new ArrayList<>(List.of(new Damage(10))));
        description = "Does 10 damage";
    }
}
