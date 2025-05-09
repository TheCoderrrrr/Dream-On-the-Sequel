package game.ui.buttons;

import game.World;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class GetRelicButton extends Button{
    public GetRelicButton(int x, int y, int width, int height) {
        super(x, y, width, height);
        used = false;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRoundRect(x, y, width, height, 2, 2);
        g.fillRoundRect(x, y, width, height, 2, 2);
        g.setColor(Color.lightGray);
        g.drawString("new relic", x, y);
    }

    @Override
    public void action() {
        if(!used){
            used = true;
            World.enterCardSelectionScreen();
            System.out.println("given relic");
        }
        System.out.println("given relic");
    }
}
