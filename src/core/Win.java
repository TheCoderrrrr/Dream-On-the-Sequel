package core;

import game.World;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Win extends BasicGameState {
     StateBasedGame sbg;
     private int id;
     private static World world;

     public Win(int id)
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

     public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
     {

     }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
         g.drawString("hi", 1000, 1000);

         g.setColor(Color.white);
         g.drawRect(Main.getScreenWidth()/2 - 125, Main.getScreenHeight()/2 - 500, 300, 250);

        g.drawRect(Main.getScreenWidth()/2 - 125, Main.getScreenHeight()/2 + 250, 300, 250);

        g.drawString("click here for new card", Main.getScreenWidth()/2, Main.getScreenHeight()/2-375);
        g.drawString("click here for new relic", Main.getScreenWidth()/2, Main.getScreenHeight()/2+375);
    }

    public void mousePressed(int button, int x, int y)
    {
        if(button == 0) {
            if(x >= Main.getScreenWidth()/2 - 125 && x <= Main.getScreenWidth()/2 + 125) {
                if(y >= Main.getScreenHeight()/2 - 500 && y <= Main.getScreenHeight()/2 - 250) {
                    //new card

                    world.addNewCard();

                    sbg.enterState(Main.GAME_ID);
                }

                if(y >= Main.getScreenHeight()/2 + 250 && y <= Main.getScreenHeight()/2 + 500) {
                    //new relic
                    world.addNewRelic();

                    sbg.enterState(Main.GAME_ID);

                }
            }
        }
    }
}
