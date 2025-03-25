package game.ui;

import game.actions.Action;
import game.managers.HitBox;

import java.awt.*;

public class NextActionPanel extends Panel{
    private Action nextAction;
    public NextActionPanel(HitBox hitBox, Action action){
        super(hitBox.getWidth(), hitBox.getY());
        nextAction = action;
    }

    @Override
    public void render(Graphics g) {
        if(!(nextAction == null)){

        }

    }
    public void updateNextAction(Action action){
        nextAction = action;
    }
}
