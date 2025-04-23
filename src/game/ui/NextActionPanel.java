package game.ui;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Effect;
import game.managers.HitBox;
import org.newdawn.slick.Graphics;

import java.awt.*;

public class NextActionPanel extends Panel{
    private Action nextAction;
    public NextActionPanel(){
        tooltip = new Tooltip();
    }
    public void updateNextAction(Action action){
        nextAction = action;
        System.out.println("called");
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(nextAction.getSymbol(), x, y);
        for(Effect e : nextAction.getEffects()){
            if(e instanceof Damage){
                g.drawString(((Damage) e).getDamage() + "", x, y);
            }
        }
        if(gc.getInput().getMouseX() > x && gc.getInput().getMouseX() < x + nextAction.getSymbol().getWidth() && gc.getInput().getMouseY() > y && gc.getInput().getMouseY() < y + nextAction.getSymbol().getHeight()){
            tooltip.render(g, gc.getInput().getMouseX(), gc.getInput().getMouseY(), nextAction.getDescription());
        }
//        g.drawString(nextAction.getName(),x - 50, y);
    }
}
