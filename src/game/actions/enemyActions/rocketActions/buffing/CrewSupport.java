package game.actions.enemyActions.rocketActions.buffing;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Shield;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class CrewSupport extends Action {
    public CrewSupport()
    {
        super(new ArrayList<>(List.of(new Shield(1.0f, 1))));
        description = "Adds shield for 1 round";
        symbol = Images.ACTION_SHIELD;
    }
}
