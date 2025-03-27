package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Win extends BasicGameState {
     StateBasedGame sbg;
     private int id;
     private Image background;

     public Win()
     {
         this.id = id;
     }

     public int getID()
     {
         return id;
     }

     public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
         this.sbg = sbg;
     }

     public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
     {

     }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
         background = new Image("res/images/backgrounds/Victory.png").getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
    }
}
