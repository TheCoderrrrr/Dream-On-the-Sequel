package game.ui;

import org.newdawn.slick.Graphics;

import java.awt.*;

public abstract class Panel {

    protected int width;
    protected int height;
    protected String name;
    protected String description;
    protected Tooltip tooltip;
    public Panel(){

    }
    public abstract void render(Graphics g, int x, int y);

}
