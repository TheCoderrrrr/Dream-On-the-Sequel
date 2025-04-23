package game.actions.enemyActions.godzillaActions.attack;

import game.actions.Action;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Tailwhip extends Action {
    public Tailwhip()
    {
        super(new ArrayList<>(List.of(new Damage(15))));
        description = "Does 15 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
