package game.actions.enemyActions.truckActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class RamSlam extends Action implements Attacking {
    public RamSlam()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 15 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
