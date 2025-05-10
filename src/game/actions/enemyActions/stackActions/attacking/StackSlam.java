package game.actions.enemyActions.stackActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class StackSlam extends Action implements Attacking {
    public StackSlam()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
