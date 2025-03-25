package game.ui;

import java.awt.*;

public abstract class Panel {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected String name;
    protected String description;
    protected Tooltip tooltip;
    public Panel(int x, int y){

    }
    public abstract void render(Graphics g);

}
