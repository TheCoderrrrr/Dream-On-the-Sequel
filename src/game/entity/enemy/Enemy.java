package game.entity.enemy;

import game.actions.Action;
import game.entity.Entity;
import game.entity.player.Player;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Fonts;
import resources.Images;

import java.util.ArrayList;

public abstract class Enemy extends Entity {
    private static final int MOVE_LOOKAHEAD = 5;
    protected ArrayList<Action> allMoves;
    protected final ArrayList<Action> nextMoves;
    protected String name;
    protected Entity player;

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
    public void initializeTarget(Entity entity){
        player = entity;
    }

    @Override
    public void action() {
        if(player != null){
            nextMoves.getFirst().action(player, this); //do the first time in action queue
            nextMoves.removeFirst();//remove that thing
            nextMoves.add(allMoves.get((int) (Math.random() * allMoves.size()))); //add a new one to the queue
        }
    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x, y);
        g.drawString(this.getClass().getSimpleName(), x, y);
        for(int i=0; i<nextMoves.size(); i++) {
            g.drawString(nextMoves.get(i).getClass().getSimpleName(), x, y -20*(i+1));
        }
        Fonts.REGULAR.drawString(g , "Hp : " + health + " ", (float) x, (float) y+20, 25);
    }
    public Image getImage(){
        if(image != null) return image;
        else return null;
    }

}