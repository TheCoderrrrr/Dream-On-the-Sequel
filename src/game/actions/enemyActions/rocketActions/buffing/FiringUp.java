package game.actions.enemyActions.rocketActions.buffing;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Heal;
import game.effects.Strength;
import game.effects.Vulnerable;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class FiringUp extends Action implements Attacking {
    public FiringUp()
    {
        super(new ArrayList<>(List.of(new Vulnerable(.75f, 1))));
        description = "'Vulnerable' effect is applied for 1 round";
        symbol = Images.ACTION_VULNERABLE;
    }
}
