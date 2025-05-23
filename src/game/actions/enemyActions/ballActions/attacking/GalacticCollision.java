package game.actions.enemyActions.ballActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class GalacticCollision extends Action implements Attacking {
    public GalacticCollision()
    {
        super(new ArrayList<>(List.of(new Damage(7))));
        description = "Does 7 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
