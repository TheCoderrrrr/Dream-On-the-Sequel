package game.actions.enemyActions.stackActions.attacking;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class TotemSpin extends Action {
    public TotemSpin()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 15 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
