package game.actions.enemyActions;


import game.actions.Action;
import game.actions.Attacking;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class Punch extends Action implements Attacking {

    public Punch() {
        super(new ArrayList<>(List.of(new Damage(10))));
    }
}
