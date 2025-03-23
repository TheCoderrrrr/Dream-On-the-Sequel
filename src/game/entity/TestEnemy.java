package game.entity;

import game.actions.Action;
import game.actions.enemyActions.Bonk;
import game.actions.enemyActions.Punch;
import game.actions.enemyActions.Slap;

import java.util.ArrayList;
import java.util.Arrays;

public class TestEnemy extends Enemy {

    public TestEnemy() {
        super((int) (Math.random() * 200));
        allMoves = new ArrayList<>(Arrays.asList(new Bonk(), new Punch(), new Slap()));
        super.initializeMoves();
    }

    @Override
    public void action() {
        nextMoves.getFirst().action(); //do the first time in action queue
        nextMoves.removeFirst();//remove that thing
        nextMoves.add(allMoves.get((int) (Math.random() * allMoves.size()))); //add a new one to the queue
    }
}
