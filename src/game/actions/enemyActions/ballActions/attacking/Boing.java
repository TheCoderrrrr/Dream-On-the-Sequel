package game.actions.enemyActions.ballActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Burn;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Boing extends Action implements Attacking {
    public Boing()
    {
        super(new ArrayList<>(List.of(new Damage(30), new Burn(5,2))));
        description = "Does 30 damage and 'Burn' affect is applied";
        symbol = Images.ACTION_BURN;
    }
}
