package game.actions.enemyActions.horseActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class ManeDash extends Action implements Attacking {
    public ManeDash()
    {
        super(new ArrayList<>(List.of(new Damage(8))));
        description = "Does 8 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
