package game.actions.enemyActions.godzillaActions.buffing;

import game.actions.Action;
import game.effects.Shield;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Fortitude extends Action {
    public Fortitude()
    {
        super(new ArrayList<>(List.of(new Shield(0.1f, 2))));
        description = "Shield is applied";
        symbol = Images.ACTION_SHIELD;
    }
}
