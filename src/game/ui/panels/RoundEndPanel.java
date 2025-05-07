package game.ui.panels;

import core.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class RoundEndPanel extends Panel{
    private boolean getRelic = false;
    private boolean getCard = true;
    private GameContainer gc;
    public RoundEndPanel(GameContainer gc){
        this.gc = gc;
        width = (int) (Main.getScreenWidth() * 0.25f);
    }
    public void render(Graphics g, int x, int y){

    }
}
