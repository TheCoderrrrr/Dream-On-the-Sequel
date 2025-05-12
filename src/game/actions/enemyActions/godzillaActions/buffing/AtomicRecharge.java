package game.actions.enemyActions.godzillaActions.buffing;

import game.actions.Action;
import game.actions.Attacking;
import game.actions.Buffing;
import game.effects.Damage;
import game.effects.Heal;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class AtomicRecharge extends Action implements Buffing{
    public AtomicRecharge()
    {
        super(new ArrayList<>(List.of(new Heal(15, 1))));
        description = "Heals 15";
        symbol = Images.ACTION_HEAL;
    }
}
