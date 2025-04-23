package game.actions.enemyActions.stackActions.attacking;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class TowerBlock extends Action {
    public TowerBlock()
    {
        super(new ArrayList<>(List.of(new Damage(10))));
        description = "Does 10 damage and 'Shield' effect is applied";
        symbol = Images.ACTION_SHIELD;
    }
}
