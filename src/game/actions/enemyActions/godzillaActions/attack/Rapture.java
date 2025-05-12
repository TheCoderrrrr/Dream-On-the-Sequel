package game.actions.enemyActions.godzillaActions.attack;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import game.effects.Vulnerable;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Rapture extends Action implements Attacking{
    public Rapture()
    {
        super(new ArrayList<>(List.of(new Damage(20), new Vulnerable(.75f, 2))));
        description = "Does 20 damage and 'Vulnerable' effect is applied";
        symbol = Images.ACTION_VULNERABLE;
    }
}
