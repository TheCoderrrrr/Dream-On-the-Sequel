package game.actions.enemyActions.duckActions.attacks;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Quack extends Action implements Attacking {
    public Quack()
    {
        super(new ArrayList<>(List.of(new Damage(5))));
        description = "Does 5 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
