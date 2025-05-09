package game.entity.enemy.miniboss;

import game.actions.enemyActions.stackActions.attacking.RingBlaster;
import game.actions.enemyActions.stackActions.attacking.StackSlam;
import game.actions.enemyActions.stackActions.attacking.TotemSpin;
import game.actions.enemyActions.stackActions.attacking.TowerBlock;
import game.actions.enemyActions.stackActions.buffing.TowerShield;
import game.entity.enemy.Enemy;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Stack extends Enemy {
    public Stack()
    {
        super(100);
        image = Images.STACKENEMY;
        allMoves = new ArrayList<>(Arrays.asList(new RingBlaster(), new StackSlam(), new TotemSpin(), new TowerBlock(), new TowerShield()));
        super.initializeMoves();
    }

}
