package game.actions.enemyActions.truckActions.buffing;

import game.actions.Action;
import game.effects.Heal;

import java.util.ArrayList;
import java.util.List;

public class PitStop extends Action {
    public PitStop()
    {
        super(new ArrayList<>(List.of(new Heal(10, 1))));
        description = "Heals 10";
    }
}
