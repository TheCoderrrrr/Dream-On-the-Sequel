package game.actions.enemyActions.dollActions.buffings;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Poison;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Curse extends Action implements Attacking {
    public Curse()
    {
        super(new ArrayList<>(List.of(new Poison(10, 2))));
        description = "'Poison' affect is applied for 2 rounds";
        symbol = Images.ACTION_POISON;
    }
}
