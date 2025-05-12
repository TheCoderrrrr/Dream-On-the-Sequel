package game.actions.enemyActions.horseActions.attacking;

import game.actions.Action;
import game.actions.Attacking;
import game.actions.Buffing;
import game.effects.Damage;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class HoofStomp extends Action implements Attacking{
    public HoofStomp()
    {
        super(new ArrayList<>(List.of(new Damage(5))));
        description = "Does 5 damage";
        symbol = Images.ACTION_ATTACK;
    }
}
