package game.ui.buttons;

import game.World;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Fonts;

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
        g.fillRect(x, y, width, height);
        if(!used){
            g.setColor(Color.black);
        }else{
            g.setColor(Color.white);
        }
        g.drawRect(x, y, width, height);
        Fonts.DOGICAPIXEL.drawStringCentered(g, "Obtain A New Card", x + width / 2, y + height / 2, 30);

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
