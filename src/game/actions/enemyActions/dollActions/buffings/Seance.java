package game.actions.enemyActions.dollActions.buffings;

import game.actions.Action;
import game.actions.Buffing;
import game.effects.Heal;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Seance extends Action implements Buffing {
    public Seance()
    {
        super(new ArrayList<>(List.of(new Heal(10, 1))));
        description = "Heals 10 HP for 1 round";
        symbol = Images.ACTION_HEAL;
    }
}
