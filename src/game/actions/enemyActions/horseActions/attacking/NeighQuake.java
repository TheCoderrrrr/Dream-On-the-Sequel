package game.actions.enemyActions.horseActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class NeighQuake extends Action implements Attacking {
    public NeighQuake()
    {
        super(new ArrayList<>(List.of(new Damage(10))));
        description = "Does 10 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
