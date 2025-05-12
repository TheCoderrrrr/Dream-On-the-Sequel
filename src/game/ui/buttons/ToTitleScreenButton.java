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
        g.setColor(new Color(210, 216, 84));
        g.fillRoundRect(x, y, width, height, 2, 2);
        g.setColor(Color.black);
        Fonts.DOGICAPIXEL.drawStringCentered(g, "Click To Go Back", x + width / 2, y + height / 2, 40);
    }

    @Override
    public void action() {
        Tutorial.enterTitle();
    }
}
