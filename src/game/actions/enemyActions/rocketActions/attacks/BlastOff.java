package game.actions.enemyActions.rocketActions.attacks;

import game.actions.Action;
import game.actions.Attacking;
import game.actions.Buffing;
import game.effects.Damage;
import game.effects.Heal;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class BlastOff extends Action implements Buffing {
    public BlastOff()
    {
        super(new ArrayList<>(List.of(new Heal(15, 1))));
        description = "Heals 15 HP for 1 round";
        symbol = Images.ACTION_HEAL;
    }
}
