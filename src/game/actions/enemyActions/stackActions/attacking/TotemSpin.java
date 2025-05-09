package game.actions.enemyActions.stackActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class TotemSpin extends Action implements Attacking {
    public TotemSpin()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 10 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
