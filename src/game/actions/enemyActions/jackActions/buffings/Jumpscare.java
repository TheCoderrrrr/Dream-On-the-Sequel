package game.actions.enemyActions.jackActions.buffings;

import game.actions.Action;
import game.actions.Attacking;
import game.effects.Vulnerable;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Jumpscare extends Action implements Attacking {
    public Jumpscare()
    {
        super(new ArrayList<>(List.of(new Vulnerable(.8f, 1))));
        description = "'Vulnerable' effect applied for 1 round";
        symbol = Images.ACTION_VULNERABLE;
    }
}
