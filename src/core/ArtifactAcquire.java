package core;

import game.World;
import game.artifacts.Artifact;
import game.card.Card;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ArtifactAcquire extends BasicGameState {
     private StateBasedGame sbg;
     private Artifact addedArtifact;
     private int id;
     private static World world;

     public ArtifactAcquire(int id)
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
        addedArtifact = world.addNewRelic();

        // This code happens when you enter a gameState.
    }

     public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
     {

     }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        if(addedArtifact != null) {
            addedArtifact.render(g, Main.getScreenWidth()/2, Main.getScreenHeight()/2);
        }
        g.drawString("press anywhere to return", Main.getScreenWidth()/2, 500);
        g.drawString("you got a new relic!", Main.getScreenWidth()/2, -500);
    }

    public void mousePressed(int button, int x, int y)
    {
        if(button == 0) {
            sbg.enterState(Main.GAME_ID);
        }
    }
}
