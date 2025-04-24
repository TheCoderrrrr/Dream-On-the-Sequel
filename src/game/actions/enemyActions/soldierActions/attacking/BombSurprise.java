package game.actions.enemyActions.soldierActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import game.effects.Vulnerable;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class BombSurprise extends Action implements Attacking {
    public BombSurprise()
    {
        super(new ArrayList<>(List.of(new Damage(15), new Vulnerable(.75f, 2))));
        description = "Does 15 damage and 'Vulnerable' effect is applied";
        symbol = Images.ACTION_VULNERABLE;
    }
}
