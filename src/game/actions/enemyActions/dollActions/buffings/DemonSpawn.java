package game.actions.enemyActions.dollActions.buffings;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Burn;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class DemonSpawn extends Action implements Attacking {
    public DemonSpawn()
    {
        super(new ArrayList<>(List.of(new Burn(10, 2))));
        description = "'Burn' effect is applied for 2 rounds";
        symbol = Images.ACTION_BURN;
    }
}
