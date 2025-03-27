package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

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
    }

    public void update(GameContainer gc,StateBasedGame sbg, int delta) throws SlickException
    {

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        background = new Image("res/images/backgrounds/Title.png").getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
    }

    public void keyPressed(int key, char c)
    {
        if(key == Input.KEY_R)
        {
            sbg.enterState(Main.TITLE_ID);
        }

    }

}
