package game.entity;

import game.actions.enemyActions.Bonk;
import game.actions.enemyActions.Punch;
import game.actions.enemyActions.Slap;
import game.entity.enemy.Enemy;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class TestEnemy extends Enemy {

    public TestEnemy() {
        super((int) (Math.random() * 200));
        allMoves = new ArrayList<>(Arrays.asList(new Bonk(), new Punch(), new Slap()));
        super.initializeMoves();
        image = Images.ENEMY2;
    }

    @Override
    public void action() {
        if(nextMoves.getFirst() instanceof Bonk){
            nextMoves.getFirst().action(this, this);//do the first time in action queue
        }else{
            nextMoves.getFirst().action(player, this);
        }
        nextMoves.removeFirst();//remove that thing
        nextMoves.add(allMoves.get((int) (Math.random() * allMoves.size()))); //add a new one to the queue
    }
}
