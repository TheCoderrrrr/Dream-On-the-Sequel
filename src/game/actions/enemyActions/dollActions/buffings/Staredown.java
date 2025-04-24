package game.actions.enemyActions.dollActions.buffings;

import game.actions.Action;
import game.effects.Vulnerable;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Staredown extends Action {
    public Staredown()
    {
        super(new ArrayList<>(List.of(new Vulnerable(2f, 1))));
        description = "'Vulnerable' effect is applied for 1 round";
        symbol = Images.ACTION_VULNERABLE;
    }
}
