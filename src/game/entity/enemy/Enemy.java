package game.entity.enemy;

import game.actions.Action;
import game.actions.Attacking;
import game.managers.HitBox;
import game.ui.NextActionPanel;
import org.newdawn.slick.Graphics;
import resources.Fonts;
import resources.Images;

import java.util.ArrayList;

public abstract class Enemy extends game.entity.Entity {
    private static final int MOVE_LOOKAHEAD = 5;
    protected ArrayList<Action> allMoves;
    protected final ArrayList<Action> nextMoves;
    protected String name;
    protected game.entity.Entity player;
    protected NextActionPanel nextActionPanel;

    public Enemy(int maxHealth) {
        super(maxHealth);
        nextMoves = new ArrayList<>();
        allMoves = new ArrayList<>();
        nextActionPanel = new NextActionPanel();
        image = Images.GODZILLA;
        name = "you forgot to set name";
    }

    protected void initializeMoves() {
        while (nextMoves.size() < MOVE_LOOKAHEAD) {
            nextMoves.add(allMoves.get((int) (Math.random() * allMoves.size())));
        }
        nextActionPanel.updateNextAction(nextMoves.getFirst());
    }
    public void assignHitBox(HitBox h){
        myHitBox = h;
    }

    public void initializeTarget(game.entity.Entity entity) {
        player = entity;
    }

    @Override
    public void action() {
        if (player != null) {
            if (nextMoves.getFirst() instanceof Attacking) {
                nextMoves.getFirst().action(player, this); //do the first time in action queue //if the action is of attacking type attack player
            } else {
                nextMoves.getFirst().action(this, this); //if action is of buffing type attack itself?
            }
            nextMoves.removeFirst();//remove that thing
            nextMoves.add(allMoves.get((int) (Math.random() * allMoves.size()))); //add a new one to the queue
            nextActionPanel.updateNextAction(nextMoves.getFirst());
        }
    }

    @Override
    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x, y);
//        g.drawString(this.getClass().getSimpleName(), x, y);

        nextActionPanel.render(g, x, y);
//        for (int i = 0; i < nextMoves.size(); i++) {
//            g.drawString(nextMoves.get(i).getClass().getSimpleName(), x + 100, y - 20 * (i + 1));
//        }

        Fonts.REGULAR.drawString(g, "Hp : " + health + " ", (float) x, (float) y + 20, 25);
        effectsPanel.render(g, x, y);
    }



}