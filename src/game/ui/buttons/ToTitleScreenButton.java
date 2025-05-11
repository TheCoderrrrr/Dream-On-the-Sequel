package game.ui.buttons;

import core.Tutorial;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Fonts;

public class ToTitleScreenButton extends Button{
    public ToTitleScreenButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRoundRect(x, y, width, height, 2, 2);
        g.setColor(Color.lightGray);
        Fonts.DOGICAPIXEL.drawString(g, "Click To Go Back", x, y, 40);
    }

    @Override
    public void action() {
        Tutorial.enterTitle();
    }
}
