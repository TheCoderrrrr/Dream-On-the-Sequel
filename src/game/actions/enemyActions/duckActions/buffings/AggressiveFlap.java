package game.actions.enemyActions.duckActions.buffings;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Mark;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class AggressiveFlap extends Action implements Attacking {
    public AggressiveFlap()
    {
        super(new ArrayList<>(List.of(new Mark(1.5f, 1))));
        description = "'Mark' effect is applied for 1 round";
        symbol = Images.ACTION_MARK;
    }
}
