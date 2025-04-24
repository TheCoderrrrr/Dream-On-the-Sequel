package game.actions.enemyActions.rocketActions.buffing;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Heal;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Cooldown extends Action {
    public Cooldown()
    {
        super(new ArrayList<>(List.of(new Heal(15, 1))));
        description = "Heals 15 HP for 1 round";
        symbol = Images.ACTION_HEAL;
    }
}
