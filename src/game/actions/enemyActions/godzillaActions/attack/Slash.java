package game.actions.enemyActions.godzillaActions.attack;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class Slash extends Action{
    public Slash()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage";
    }
}
