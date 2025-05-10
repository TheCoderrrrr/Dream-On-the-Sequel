package game.actions.enemyActions.duckActions.attacks;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Splash extends Action implements Attacking {
    public Splash()
    {
        super(new ArrayList<>(List.of(new Damage(10))));
        description = "Does 10 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
