package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;
import resources.Images;
import resources.Sounds;

public class Win extends BasicGameState {
    StateBasedGame sbg;
    private int id;
    private Image background;

    public Win(int id) {
        this.id = id;
    }

    public int getID()
    {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
        background = Images.WIN_SCREEN.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
    }
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        Sounds.BGMUSIC1.loop(1F, .2F);
    }
    public void update(GameContainer gc,StateBasedGame sbg, int delta) throws SlickException
    {

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
        g.drawImage(background.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight()), 0, 0);
        g.setColor(Color.black);
        Fonts.EXO2.drawStringCentered(g, "YOU WON PRESS R TO RETURN TO TITLESCREEN", Main.getScreenWidth() / 2, Main.getScreenHeight() / 2, 60);
    }

    public void keyPressed(int key, char c)
    {
        if(key == Input.KEY_R)
        {
            sbg.enterState(Main.TITLE_ID);
        }

    }

}
