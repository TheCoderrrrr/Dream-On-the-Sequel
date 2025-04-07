package game.ui;

import game.actions.Action;
import game.managers.HitBox;
import org.newdawn.slick.Graphics;

import java.awt.*;

public class NextActionPanel extends Panel{
    private Action nextAction;
    public NextActionPanel(HitBox hitBox, Action action){
        nextAction = action;
    }
    public void updateNextAction(Action action){
        nextAction = action;
    }

    @Override
    public void render(Graphics g, int x, int y) {

    }
}
