package game.entity.enemy.miniboss;

import game.actions.enemyActions.jackActions.attacks.LoadedSpring;
import game.actions.enemyActions.jackActions.attacks.Pop;
import game.actions.enemyActions.jackActions.buffings.Hide;
import game.actions.enemyActions.jackActions.buffings.Jumpscare;
import game.actions.enemyActions.jackActions.buffings.ReSpring;
import game.entity.enemy.Enemy;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Jack extends Enemy {
    public Jack(int maxHealth)
    {
        super(maxHealth * 2);
        image = Images.JACK;
        allMoves = new ArrayList<>(Arrays.asList(new LoadedSpring(), new Pop(), new Hide(), new Jumpscare(), new ReSpring()));
        this.initializeMoves();
    }


}
