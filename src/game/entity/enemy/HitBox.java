package game.entity.enemy;

import game.entity.Entity;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;


public class HitBox {
    private int x;
    private int y;
    private int width;
    private int height;
    private final int OFFSET = 25; //extends the hitbox 25 pixels on each side of the entity
    public HitBox(Entity enemy){
        this.x = x - OFFSET;
        this.y = y - OFFSET;
        this.height = height + OFFSET;
        this.width = width + OFFSET;
    }

    public void render(Graphics g, int x, int y){
        g.setColor(Color.white);
        g.drawRect(x, y, width, height);
    }
}
