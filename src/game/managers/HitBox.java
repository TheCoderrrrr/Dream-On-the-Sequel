package game.managers;

import game.card.Card;
import game.card.MultiTarget;
import game.card.SingleTarget;
import game.entity.Entity;
import game.entity.player.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;


public class HitBox {
    private int x;
    private int y;
    private final int OFFSET = 25; //extends the hitbox 25 pixels on each side of the entity
    private Entity entity;
    private Player player;
    private Color curColor;
    private int curColorNumber;
    private int width;
    private int height;
    private static List<Color> colors = new ArrayList<>();
    public HitBox(int x, int y){
        this.x = x - OFFSET;
        this.y = y - OFFSET;
        for (int r=0; r<100; r++) colors.add(new Color(r*255/100,       255,         0));
        for (int g=100; g>0; g--) colors.add(new Color(      255, g*255/100,         0));
        for (int b=0; b<100; b++) colors.add(new Color(      255,         0, b*255/100));
        for (int r=100; r>0; r--) colors.add(new Color(r*255/100,         0,       255));
        for (int g=0; g<100; g++) colors.add(new Color(        0, g*255/100,       255));
        for (int b=100; b>0; b--) colors.add(new Color(        0,       255, b*255/100));
        colors.add(new Color(        0,       255,         0));
        curColorNumber = 0;
        curColor = Color.white;
        System.out.println(colors.size());
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
        width = entity.getImage().getWidth() + OFFSET;
        height = entity.getImage().getHeight() + OFFSET;
    }


    public Entity getEntity() {return entity;}
    public void setPlayer(Player player) {this.player = player;}
    public boolean hasEntity() {
        return entity != null;
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        return hasEntity() && mouseX < x + width && mouseX > x - OFFSET && mouseY < y + height + OFFSET && mouseY > y - OFFSET;
    }

    public void useCard(Card c) {
        c.markAsUsed();
        if(c instanceof SingleTarget) {
            ((SingleTarget) c).use(player, entity);
        }
        if(c instanceof MultiTarget) {
            ((MultiTarget) c).use(player);
        }
        CardManager.spendEnergy(c.getEnergyCost());
    }

    public void render(Graphics g){

        if(hasEntity()) {
            entity.render(g, x, y);
        }
    }
    public void renderHitBox(Graphics g) {
        g.setColor(curColor);
        g.drawRect(x - OFFSET, y - OFFSET, entity.getImage().getWidth() + OFFSET, entity.getImage().getHeight() + OFFSET);
    }
    public void chroma(){
        if(curColorNumber  > 3000){
            curColorNumber = 0;
        }else{
            curColorNumber++;
        }
        curColor = colors.get(curColorNumber);

    }
    public void killEntity(){
        entity = null;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public int getX(){
        return x - OFFSET;
    }
    public int getY(){
        return y - OFFSET;
    }
}
