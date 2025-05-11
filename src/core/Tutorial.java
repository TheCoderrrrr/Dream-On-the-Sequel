package core;

import net.java.games.input.Component;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;
import resources.Images;
import resources.Sounds;

public class Tutorial extends BasicGameState {
    private int id;
    private Image background;
    private StateBasedGame sbg;

    public Tutorial(int id){
        this.id = id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Sounds.loadMusic();
        Sounds.loadSounds();
        Images.loadImages();
        Images.loadSymbols();
        Fonts.loadFonts();
        this.sbg = sbg;
        background = Images.TUTORIALSCREEN_BACKGROUND.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
//        Sounds.BGMUSIC2.loop(1F, .2F);
    }

    public int getID() {
        return id;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }
    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
    }

    public void leave(GameContainer gc, StateBasedGame sbg)
    {
    }

    public void keyPressed(int key, char c)
    {
        if(key == Input.KEY_T){
            sbg.enterState(Main.TITLE_ID);
        }
    }

    public void mousePressed(int button, int x, int y)
    {
    }
}
