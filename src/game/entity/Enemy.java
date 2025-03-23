package game.entity;

import game.actions.Action;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public abstract class Enemy extends Entity {
    private static final int MOVE_LOOKAHEAD = 5;
    protected ArrayList<Action> allMoves;
    protected final ArrayList<Action> nextMoves;

    public Enemy(int maxHealth) {
        super(maxHealth);
        nextMoves = new ArrayList<>();
        allMoves = new ArrayList<>();
    }

    protected void initializeMoves() {
        while(nextMoves.size() < MOVE_LOOKAHEAD) {
            nextMoves.add(allMoves.get((int) (Math.random() * allMoves.size())));
        }
    }

    @Override
    public void action() {
        nextMoves.getFirst().action(); //do the first time in action queue
        nextMoves.removeFirst();//remove that thing
        nextMoves.add(allMoves.get((int) (Math.random() * allMoves.size()))); //add a new one to the queue
    }

    @Override
    public void render(Graphics g) {
        g.drawString(this + "", 0, 0);
        for(int i=0; i<nextMoves.size(); i++) {
            g.drawString(nextMoves.get(i).toString(), 0, -20*i);
        }
    }
}
