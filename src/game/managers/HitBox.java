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
    private Enemy enemy;
    private Player player;
    private Color curColor;
    private int curColorNumber;
    private static List<Color> colors = new ArrayList<>();
    public HitBox(int x, int y){
        this.x = x - OFFSET;
        this.y = y - OFFSET;
        this.height = height + OFFSET;
        this.width = width + OFFSET;
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
}
