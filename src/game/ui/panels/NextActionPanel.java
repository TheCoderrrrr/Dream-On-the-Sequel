package game.ui.panels;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Effect;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

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
        int width = nextAction.getSymbol().getWidth();
        int height = nextAction.getSymbol().getHeight();

        g.setColor(new org.newdawn.slick.Color(0, 0, 0, 150));
        g.fillRoundRect(x - 5, y - 5, width + 10, height + 10, 10);

        g.drawImage(nextAction.getSymbol(), x, y);
        for(Effect e : nextAction.getEffects()){
            if(e instanceof Damage){
                g.setColor(Color.white);
                g.drawString(((Damage) e).getDamage() + "", x + 5, y + 5);
            }
        }
        if(gc.getInput().getMouseX() > x && gc.getInput().getMouseX() < x + nextAction.getSymbol().getWidth() && gc.getInput().getMouseY() > y && gc.getInput().getMouseY() < y + nextAction.getSymbol().getHeight()){
            tooltip.render(g, gc.getInput().getMouseX(), gc.getInput().getMouseY(), nextAction.getDescription());
        }
//        g.drawString(nextAction.getName(),x - 50, y);
    }
}
