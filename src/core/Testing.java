package core;

import game.card.Card;
import game.card.bearCards.mutli.attack.ButtonBarrage;
import game.managers.CardManager;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;
import resources.Images;
import resources.Sounds;

public class Testing extends BasicGameState {
    private int id;
    private Image background;
    private StateBasedGame sbg;
    private Card testCard;
    private CardManager cardManager;

    public Testing(int id) {
        this.id = id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.sbg = sbg;
        background = Images.BACKGROUND;
        testCard = new ButtonBarrage();
    }

    public int getID() {
        return id;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0);
        testCard.render(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    public void leave(GameContainer gc, StateBasedGame sbg) {
    }

    public void keyPressed(int key, char c) {
        sbg.enterState(Main.GAME_ID);
    }

    public void mousePressed(int button, int x, int y) {
    }
}
