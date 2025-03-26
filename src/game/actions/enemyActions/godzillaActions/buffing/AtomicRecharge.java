package game.actions.enemyActions.godzillaActions.buffing;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Heal;

import java.util.ArrayList;
import java.util.List;

public class AtomicRecharge extends Action {
    public AtomicRecharge()
    {
        super(new ArrayList<>(List.of(new Heal(15, 1))));
        description = "Heals 15";
    }
}
