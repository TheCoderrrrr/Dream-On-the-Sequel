package game.actions.enemyActions.godzillaActions.attack;
import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import game.effects.Mark;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class PlasmaRay extends Action implements Attacking {
    public PlasmaRay()
    {
        super(new ArrayList<>(List.of(new Damage(30), new Mark(1.5f, 2))));
        description = "Does 30 damage and 'Mark' effect is applied";
        symbol = Images.ACTION_MARK;

    }
}
