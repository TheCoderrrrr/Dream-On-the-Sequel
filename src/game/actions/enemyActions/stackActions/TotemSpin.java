package game.actions.enemyActions.stackActions;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class TotemSpin extends Action {
    public TotemSpin()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 15 damage";
    }
}
