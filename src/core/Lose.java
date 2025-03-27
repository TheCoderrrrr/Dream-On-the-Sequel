package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Images;

public class Lose extends BasicGameState {
    StateBasedGame sbg;
    private int id;
    private Image background;

    public Lose(int id) {
        this.id = id;
    }

    public int getID()
    {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
        background = Images.LOSE_SCREEN.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
    }

    public void update(GameContainer gc,StateBasedGame sbg, int delta) throws SlickException
    {

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        g.drawImage(background.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight()), 0, 0);
    }

    public void keyPressed(int key, char c)
    {
        if(key == Input.KEY_R)
        {
            sbg.enterState(Main.TITLE_ID);
        }

    }

}
