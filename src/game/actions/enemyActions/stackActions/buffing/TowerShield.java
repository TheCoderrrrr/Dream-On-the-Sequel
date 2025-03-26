package game.actions.enemyActions.stackActions.buffing;

import game.actions.Action;
import game.effects.Shield;

import java.util.ArrayList;
import java.util.List;

public class TowerShield extends Action {
    public TowerShield()
    {
        super(new ArrayList<>(List.of(new Shield(10, 1))));
        description = "Shield is applied";
    }
}
