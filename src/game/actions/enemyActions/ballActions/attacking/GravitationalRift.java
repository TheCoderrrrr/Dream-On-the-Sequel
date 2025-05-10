package game.actions.enemyActions.ballActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class GravitationalRift extends Action implements Attacking {
    public GravitationalRift()
    {
        super(new ArrayList<>(List.of(new Damage(5))));
        description = "Does 5 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
