package game.ui.buttons;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class GetRelicButton extends Button{
    public GetRelicButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRoundRect(x, y, width, height, 2, 2);
    }

    @Override
    public void action() {
        System.out.println("given relic");
    }
}
