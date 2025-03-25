package game.actions.enemyActions.stackActions;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class StackSlam extends Action {
    public StackSlam()
    {
        super(new ArrayList<>(List.of(new Damage(25))));
        description = "Does 25 damage";
    }
}
