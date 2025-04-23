package game.actions.enemyActions;


import game.actions.Action;
import game.actions.Buffing;
import game.effects.Burn;
import game.effects.Damage;
import game.effects.Heal;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

public class Bonk extends Action implements Buffing {

    public Bonk() {
        super(new ArrayList<>(List.of(new Burn(1, 5))));
        symbol = Images.ACTION_HEAL;
    }
}
