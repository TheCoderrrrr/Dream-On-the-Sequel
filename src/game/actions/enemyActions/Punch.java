package game.actions.enemyActions;


import game.actions.Action;
import game.effects.Damage;

import java.util.ArrayList;
import java.util.List;

public class Punch extends Action {

    public Punch() {
        super(new ArrayList<>(List.of(new Damage(10))));
    }
}
