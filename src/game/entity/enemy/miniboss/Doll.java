package game.entity.enemy.miniboss;

import game.actions.enemyActions.dollActions.attacks.Scratch;
import game.actions.enemyActions.dollActions.buffings.Curse;
import game.actions.enemyActions.dollActions.buffings.DemonSpawn;
import game.actions.enemyActions.dollActions.buffings.Seance;
import game.actions.enemyActions.dollActions.buffings.Staredown;
import game.entity.enemy.Enemy;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Doll extends Enemy {
    public Doll()
    {
        super(100);
        image = Images.DOLL;
        allMoves = new ArrayList<>(Arrays.asList(new Scratch(), new Curse(), new DemonSpawn(), new Seance(), new Staredown()));
        super.initializeMoves();
    }
}
