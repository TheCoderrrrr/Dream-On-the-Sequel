package game.actions.enemyActions.ballActions.attacking;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class OrbitalStrike extends Action {
    public OrbitalStrike()
    {
        super(new ArrayList<>(List.of(new Damage(10))));
        description = "Does 10 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
