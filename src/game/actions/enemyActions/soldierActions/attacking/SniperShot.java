package game.actions.enemyActions.soldierActions.attacking;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class SniperShot extends Action {
    public SniperShot()
    {
        super(new ArrayList<>(List.of(new Damage(10))));
        description = "Does 10 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
