package game.actions.enemyActions.truckActions.attacking;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class CargoCover extends Action {
    public CargoCover()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 15 damage and 'Shield' effect is applied";
        symbol = Images.ACTION_SHIELD;
    }
}
