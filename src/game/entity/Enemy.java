package game.entity;

import game.actions.Action;

import java.util.ArrayList;

public abstract class Enemy extends Entity {
    private ArrayList<Action> allMoves;
    private ArrayList<Action> nextMoves;

    public Enemy(int maxHealth) {
        super(maxHealth);
    }

    @Override
    public void action() {
        nextMoves.getFirst().action(); //do the first time in action queue
        nextMoves.removeFirst();//remove that thing
        nextMoves.add(allMoves.get((int) (Math.random() * allMoves.size()))); //add a new one to the queue
    }
}
