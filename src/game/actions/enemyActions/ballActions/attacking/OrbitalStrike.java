package game.actions.enemyActions.ballActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class OrbitalStrike extends Action implements Attacking {
    public OrbitalStrike()
    {
        super(new ArrayList<>(List.of(new Damage(3))));
        description = "Does 3 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
