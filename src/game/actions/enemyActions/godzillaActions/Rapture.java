package game.actions.enemyActions.godzillaActions;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class Rapture  extends Action {
    public Rapture()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage and 'Vulnerable' effect is applied";
    }
}
