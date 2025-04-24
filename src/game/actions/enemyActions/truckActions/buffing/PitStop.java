package game.actions.enemyActions.truckActions.buffing;

import game.actions.Action;
import game.actions.Buffing;
import game.effects.Heal;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class PitStop extends Action implements Buffing {
    public PitStop()
    {
        super(new ArrayList<>(List.of(new Heal(10, 1))));
        description = "Heals 10";
        symbol = Images.ACTION_HEAL;
    }
}
