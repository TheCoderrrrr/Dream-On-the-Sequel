package game.actions.enemyActions.horseActions.attacking;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class ManeDash extends Action {
    public ManeDash()
    {
        super(new ArrayList<>(List.of(new Damage(25))));
        description = "Does 25 damage";
    }
}
