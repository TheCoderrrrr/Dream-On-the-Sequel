package game.actions.enemyActions.godzillaActions;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class LazerBeam extends Action {
    public LazerBeam()
    {
        super(new ArrayList<>(List.of(new Damage(30))));
        description = "Does 30 damage";
    }
}
