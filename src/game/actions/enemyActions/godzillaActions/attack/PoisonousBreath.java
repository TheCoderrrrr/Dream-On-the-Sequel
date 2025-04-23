package game.actions.enemyActions.godzillaActions.attack;
import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class PoisonousBreath extends Action {
    public PoisonousBreath()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 15 damage and 'Posion' effect is applied";
        symbol = Images.ACTION_POISON;
    }


}
