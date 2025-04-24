package game.actions.enemyActions.rocketActions.attacks;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Strike extends Action {
    public Strike()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
