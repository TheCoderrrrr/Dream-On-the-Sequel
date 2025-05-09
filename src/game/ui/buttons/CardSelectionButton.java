package game.ui.buttons;

import game.World;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class CardSelectionButton extends Button{
    public CardSelectionButton(int x, int y, int width, int height) {
        super(x, y, width, height);
        used = false;
    }

    @Override
    public void render(Graphics g) {
        if(used){
            g.setColor(Color.black);
        }else{
            g.setColor(Color.green);
        }
        g.fillRoundRect(x, y, width, height, 2, 2);
        g.setColor(Color.lightGray);
        g.drawString("new card", x, y);
    }

    @Override
    public void action() {
        if(!used){
            used = true;
            System.out.println(used);
            World.enterCardSelectionScreen();
            System.out.println("given vcard");
        }
    }
}
