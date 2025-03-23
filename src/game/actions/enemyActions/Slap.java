package game.actions.enemyActions;


import game.actions.Action;
import game.effects.Damage;
import game.effects.Poison;

import java.util.ArrayList;
import java.util.List;

public class Slap extends Action {

    public Slap() {
        super(new ArrayList<>(List.of(new Poison(1, 5))));
    }
}
