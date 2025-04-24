package game.actions.enemyActions.ballActions.attacking;

import game.actions.Action;
import game.effects.Burn;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Boing extends Action {
    public Boing()
    {
        super(new ArrayList<>(List.of(new Damage(40), new Burn(1,2))));
        description = "Does 40 damage and 'Burn' affect is applied";
        symbol = Images.ACTION_BURN;
    }
}
