package core;

import game.World;
import game.card.Card;
import game.managers.MessageManager;
import game.messages.FloatMessage;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class CardAcquire extends BasicGameState {
     private StateBasedGame sbg;
     private Card addedCard;
     private int id;
     private static World world;

     public CardAcquire(int id)
     {
         this.id = id;
     }

     public static void setWorld(World w) {
         world = w;
     }

     public int getID()
     {
         return id;
     }

     public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
         this.sbg = sbg;
     }

     @Override
     public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        addedCard = world.addNewCard();

        // This code happens when you enter a gameState.
    }

     public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
     {

     }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        if(addedCard != null) {
            addedCard.render(Main.getScreenWidth()/2, Main.getScreenHeight()/2, g);
        }
        g.drawString("press anywhere to return", Main.getScreenWidth()/2, 500);
        g.drawString("you got a new card!", Main.getScreenWidth()/2, -500);
    }

    public void mousePressed(int button, int x, int y)
    {
        if(button == 0) {
            sbg.enterState(Main.GAME_ID);
        }
    }
}
