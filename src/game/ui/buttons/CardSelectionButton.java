package game.ui.buttons;

import game.World;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class CardSelectionButton extends Button{
    private static boolean used;
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
    }

    @Override
    public void action() {
        if(!used){
            used = true;
            World.enterCardSelectionScreen();
            System.out.println("given vcard");
        }
    }
    public static boolean used(){
        return used;
    }
}
