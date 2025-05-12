package core;

import game.World;
import game.artifacts.Artifact;
import game.card.Card;
import game.ui.buttons.ReturnToGameButton;
import game.ui.buttons.ToGameButton;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;

public class ArtifactAcquire extends BasicGameState {
     private StateBasedGame sbg;
     private Artifact addedArtifact;
     private int id;
     private static World world;
     private static ReturnToGameButton returnToGameButton;

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
         returnToGameButton = new ReturnToGameButton((int) (Main.getScreenWidth() * 0.4), (int) (Main.getScreenHeight() * 0.7), (int) (Main.getScreenWidth() * 0.2), (int) (Main.getScreenHeight() * 0.05));
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
        g.setColor(Color.white);
        Image image = addedArtifact.getImage().getScaledCopy(3);
        Fonts.EXO2.drawStringCentered(g, "You Got A New Relic!", (float) (Main.getScreenWidth() / 2), (float) (Main.getScreenHeight() * 0.15), 60);
        if(addedArtifact != null) {
            g.drawImage(image, (float) (Main.getScreenWidth() / 2 - image.getWidth() / 2), (float) (Main.getScreenHeight() * 0.4));
            Fonts.EXO2.drawStringCentered(g, addedArtifact.getName(), (float) (Main.getScreenWidth() / 2), (float) (Main.getScreenHeight() * 0.35), 40);
            Fonts.EXO2.wrap(g, addedArtifact.getDescription(), (float) (Main.getScreenWidth() / 2 - image.getWidth() * 0.95), (float) (Main.getScreenHeight() * 0.5), 300, 30);
        }
        returnToGameButton.render(g);
//        g.drawString("press anywhere to return", Main.getScreenWidth()/2, 500);
//        g.drawString("you got a new relic!", Main.getScreenWidth()/2, -500);
    }

    public void mousePressed(int button, int x, int y)
    {
        returnToGameButton.mousePressed(button, x, y);
    }
}
