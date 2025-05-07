package game.entity.enemy;

import core.Main;
import game.actions.Action;
import game.actions.Attacking;
import game.effects.Effect;
import game.effects.Shield;
import game.ui.panels.NextActionPanel;
import org.newdawn.slick.Color;
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


    public void initializeTarget(game.entity.Entity entity) {
        player = entity;
    }

    @Override
    public void action() {
        if (player != null) {
            if (nextMoves.getFirst() instanceof Attacking) {
                nextMoves.getFirst().action(player, this); //do the first time in action queue //if the action is of attacking type attack player
                for(Effect e : player.getActiveEffects()){
                    if(e instanceof Shield){
                        e.apply();
                    }
                }
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

        nextActionPanel.render(g, x, y - 30);
//        for (int i = 0; i < nextMoves.size(); i++) {
//            g.drawString(nextMoves.get(i).getClass().getSimpleName(), x + 100, y - 20 * (i + 1));
//        }

        renderHealth(g, x , y);
    }
    public void renderHealth(Graphics g, int x, int y){
        if(image != null){
            float barWidth = (float) (image.getWidth() * 1.5);
            g.setColor(Color.black);
            g.fillRect((float) (x - barWidth / 5), (float) (y + image.getHeight() * 0.75),barWidth, (float) (Main.getScreenHeight() * 0.012));
            g.setColor(Color.red);
            g.fillRect((float) (x - barWidth / 5), (float) (y + image.getHeight() * 0.75), barWidth * getPercentHealthLeft(), (float) (Main.getScreenHeight() * 0.012));
            g.setColor(Color.white);
            Fonts.REGULAR.drawStringCentered(g , health + " / " + maxHealth, (float) x + image.getWidth() / 2, (float) (y + image.getHeight() * 0.78), 22);

            //ik this looks stupid to put in here but its so much easier
            effectsPanel.render(g, (int) (x - barWidth / 5), (int) (y + image.getHeight() * 0.84));
        }
    }



}