package game.actions.enemyActions.soldierActions.attacking;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class BombSurprise extends Action {
    public BombSurprise()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 15 damage and 'Vulnerable' effect is applied";
        symbol = Images.ACTION_VULNERABLE;
    }
}
