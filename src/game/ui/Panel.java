package game.ui;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.awt.*;

public abstract class Panel {

    protected int width;
    protected int height;
    protected String name;
    protected String description;
    protected Tooltip tooltip;
    protected static GameContainer gc;
    public Panel(){

    }
    public static void setGC(GameContainer gc){
        Panel.gc = gc;
    }
    public void render(Graphics g){}

}
