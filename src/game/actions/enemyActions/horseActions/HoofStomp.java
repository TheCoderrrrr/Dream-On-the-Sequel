package game.actions.enemyActions.horseActions;

import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class HoofStomp extends Action {
    public HoofStomp()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage";
    }
}
