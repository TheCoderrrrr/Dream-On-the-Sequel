package game.actions.enemyActions.godzillaActions.attack;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Vulnerable;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Rapture  extends Action {
    public Rapture()
    {
        super(new ArrayList<>(List.of(new Damage(20))));
        description = "Does 20 damage and 'Vulnerable' effect is applied";
        symbol = Images.ACTION_VULNERABLE;
    }
}
