package game.ui.buttons;

import core.Main;
import game.World;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Images;

public abstract class Button {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Image image;
    public Button(int x, int y, int width, int height, Image image){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Button(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void mousePressed(int button, int x, int y){
        if(isOver(x, y) && button == 0){
            action();
        }
    }
    protected boolean isOver(int mX, int mY){
        return mX > x && mX <= x + width && mY > y && mY <= y + height;
    }
    public abstract void render(Graphics g);
    public abstract void action();
}
