package game.actions.enemyActions.truckActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;


public class TurboTakedown extends Action implements Attacking {
    public TurboTakedown()
    {
        super(new ArrayList<>(List.of(new Damage(45))));
        description = "Does 45 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
