package game.actions.enemyActions.godzillaActions.attack;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class LazerBeam extends Action implements Attacking{
    public LazerBeam()
    {
        super(new ArrayList<>(List.of(new Damage(30))));
        description = "Does 30 damage";
        symbol = Images.ACTION_ATTACK;

    }
}
