package game.actions.enemyActions.duckActions.buffings;

import game.actions.Action;
import game.actions.Buffing;
import game.effects.Heal;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Roost extends Action implements Buffing {
    public Roost()
    {
        super(new ArrayList<>(List.of(new Heal(5, 3))));
        description = "Heals 5 HP for 1 round";
        symbol = Images.ACTION_HEAL;
    }
}
