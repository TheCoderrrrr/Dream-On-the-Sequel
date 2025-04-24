package game.actions.enemyActions.duckActions.attacks;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Splash extends Action {
    public Splash()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
