package game.actions.enemyActions.stackActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import game.effects.Shield;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class TowerBlock extends Action implements Attacking {
    public TowerBlock()
    {
        super(new ArrayList<>(List.of(new Damage(5), new Shield(.25f, 3))));
        description = "Does 5 damage and 'Shield' effect is applied";
        symbol = Images.ACTION_SHIELD;
    }
}
