package game.entity.enemy;

import game.actions.Action;
import game.entity.Entity;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Images;

import java.util.ArrayList;

public abstract class Enemy extends Entity {
    private static final int MOVE_LOOKAHEAD = 5;
    protected ArrayList<Action> allMoves;
    protected final ArrayList<Action> nextMoves;
    protected String name;
    protected Image image;

    public Enemy(int maxHealth) {
        super(maxHealth);
        nextMoves = new ArrayList<>();
        allMoves = new ArrayList<>();
        image = Images.GODZILLA;
        name = "you forgot to set name";
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
    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x, y);
        g.drawString(this.getClass().getSimpleName(), x, y);
        for(int i=0; i<nextMoves.size(); i++) {
            g.drawString(nextMoves.get(i).getClass().getSimpleName(), x, y -20*(i+1));
        }
        g.drawString(health + " ", x, y+20);
    }
}