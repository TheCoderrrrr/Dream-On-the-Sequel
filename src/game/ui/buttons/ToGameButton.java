package game.ui.buttons;

import core.TitleScreen;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Fonts;

public class ToGameButton extends Button{
    public ToGameButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRoundRect(x, y, width, height, 2, 2);
        g.setColor(Color.lightGray);
        Fonts.DOGICAPIXEL.drawString(g, "Click to Start", (float) (x + width * 0.1), y + (float) height / 3, 40);
    }

    @Override
    public void action() {
        TitleScreen.enterGame();
    }
}
