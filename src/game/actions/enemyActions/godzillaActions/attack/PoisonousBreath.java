package game.actions.enemyActions.godzillaActions.attack;
import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import game.effects.Poison;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class PoisonousBreath extends Action  implements Attacking {
    public PoisonousBreath()
    {
        super(new ArrayList<>(List.of(new Damage(15), new Poison(5, 3))));
        description = "Does 15 damage and 'Posion' effect is applied";
        symbol = Images.ACTION_POISON;
    }


}
