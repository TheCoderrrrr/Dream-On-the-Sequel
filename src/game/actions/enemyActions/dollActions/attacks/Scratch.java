package game.actions.enemyActions.dollActions.attacks;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Scratch extends Action implements Attacking {
    public Scratch()
    {
        super(new ArrayList<>(List.of(new Damage(25))));
        description = "Does 25 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
