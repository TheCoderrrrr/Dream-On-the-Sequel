package game.actions.enemyActions.horseActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import game.effects.Mark;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class WildWhinny extends Action implements Attacking{
    public WildWhinny()
    {
        super(new ArrayList<>(List.of(new Damage(5), new Mark(1.5f, 2))));
        description = "Does 5 damage and 'Mark' effect is applied";
        symbol = Images.ACTION_MARK;
    }
}
