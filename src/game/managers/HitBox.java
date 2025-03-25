package game.managers;

import game.card.Card;
import game.card.MultiTarget;
import game.card.SingleTarget;
import game.entity.enemy.Enemy;
import game.entity.player.Player;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;


public class HitBox {
    private int x;
    private int y;
    private final int OFFSET = 25; //extends the hitbox 25 pixels on each side of the entity
    private Enemy enemy;
    private Player player;
    private Color curColor;
    private int curColorNumber;
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
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
    public Enemy getEnemy() {return enemy;}
    public void setPlayer(Player player) {this.player = player;}
    public boolean hasEnemy() {
        return enemy != null;
    }

    public boolean isMouseOver(int mouseX, int mouseY) {
        return hasEnemy() && mouseX < x + enemy.getImage().getWidth() + OFFSET && mouseX > x - OFFSET && mouseY < y + enemy.getImage().getHeight() + OFFSET && mouseY > y - OFFSET;
    }

    public void useCard(Card c) {
        c.markAsUsed();
        System.out.println("yes");
        if(c instanceof SingleTarget) {
            ((SingleTarget) c).use(player, enemy);
        }
        if(c instanceof MultiTarget) {
            ((MultiTarget) c).use(player);
        }
    }

    public void render(Graphics g){

        if(hasEnemy()) {
            enemy.render(g, x, y);
            g.setColor(curColor);
            g.drawRect(x - OFFSET, y - OFFSET, enemy.getImage().getWidth() + OFFSET, enemy.getImage().getHeight() + OFFSET);
        }
    }
    public void chroma(){
        if(curColorNumber - 1 >= colors.size()){
            curColorNumber = 0;
        }else{
            curColorNumber++;
        }
        curColor = colors.get(curColorNumber);

    }
    public void killEnemy(){
        enemy = null;
    }
}
