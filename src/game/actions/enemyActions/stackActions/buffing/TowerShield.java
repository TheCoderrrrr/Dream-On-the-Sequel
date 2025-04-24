package game.actions.enemyActions.stackActions.buffing;

import game.actions.Action;
import game.actions.Buffing;
import game.effects.Shield;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class TowerShield extends Action implements Buffing {
    public TowerShield()
    {
        super(new ArrayList<>(List.of(new Shield(0.1f, 1))));
        description = "Shield is applied";
        symbol = Images.ACTION_SHIELD;
    }
}
