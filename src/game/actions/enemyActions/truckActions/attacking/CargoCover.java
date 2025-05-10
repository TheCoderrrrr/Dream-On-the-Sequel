package game.actions.enemyActions.truckActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.actions.Buffing;
import game.effects.Damage;
import game.effects.Shield;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class CargoCover extends Action implements Attacking, Buffing {
    public CargoCover()
    {
        super(new ArrayList<>(List.of(new Damage(10), new Shield(.3f, 2))));
        description = "Does 10 damage and 'Shield' effect is applied";
        symbol = Images.ACTION_SHIELD;
    }
}
