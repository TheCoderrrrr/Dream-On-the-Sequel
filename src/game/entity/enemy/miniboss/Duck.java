package game.entity.enemy.miniboss;

import game.actions.enemyActions.duckActions.attacks.Quack;
import game.actions.enemyActions.duckActions.attacks.Splash;
import game.actions.enemyActions.duckActions.buffings.AggressiveFlap;
import game.actions.enemyActions.duckActions.buffings.Roost;
import game.entity.enemy.Enemy;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Duck extends Enemy {
    public Duck()
    {
        super(100);
        image = Images.DUCK;
        allMoves = new ArrayList<>(Arrays.asList(new Quack(), new Splash(), new AggressiveFlap(), new Roost()));
        super.initializeMoves();
    }
}
