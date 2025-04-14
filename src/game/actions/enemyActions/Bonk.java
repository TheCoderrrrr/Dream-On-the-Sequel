package game.actions.enemyActions;


import game.actions.Action;
import game.actions.Buffing;
import game.effects.Damage;
import game.effects.Heal;

import java.util.ArrayList;
import java.util.List;

public class Bonk extends Action implements Buffing {

    public Bonk() {
        super(new ArrayList<>(List.of(new Heal(1, 5))));
    }
}
