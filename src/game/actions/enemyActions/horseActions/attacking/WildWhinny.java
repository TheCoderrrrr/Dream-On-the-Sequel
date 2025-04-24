package game.actions.enemyActions.horseActions.attacking;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Mark;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class WildWhinny extends Action {
    public WildWhinny()
    {
        super(new ArrayList<>(List.of(new Damage(20) , new Mark(1,2))));
        description = "Does 20 damage and 'Mark' effect is applied";
        symbol = Images.ACTION_MARK;
    }
}
