package game.actions.enemyActions.jackActions.buffings;

import game.actions.Action;
import game.actions.Buffing;
import game.effects.Shield;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Hide extends Action implements Buffing {
    public Hide()
    {
        super(new ArrayList<>(List.of(new Shield(.5f, 1))));
        description = "Adds shield for 1 round";
        symbol = Images.ACTION_SHIELD;
    }
}
