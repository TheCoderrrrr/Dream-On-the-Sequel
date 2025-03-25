package game.actions.enemyActions.godzillaActions;
import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class PoisonousBreath extends Action {
    public PoisonousBreath()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 15 damage and 'Posion' effect is applied";
    }


}
