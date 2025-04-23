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
    public Stack(int maxHealth)
    {
        super(maxHealth *= 2);
        image = Images.STACKENEMY;
        allMoves = new ArrayList<>(Arrays.asList(new RingBlaster(), new StackSlam(), new TotemSpin(), new TowerBlock(), new TowerShield()));
        this.initializeMoves();
    }

    protected void addMoves()
    {

    }
}
