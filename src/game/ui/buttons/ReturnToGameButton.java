package game.ui.buttons;

import core.TitleScreen;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Fonts;

public class ReturnToGameButton extends Button{
    public ReturnToGameButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(new Color(210, 216, 84));
        g.fillRoundRect(x, y, width, height, 2, 2);
        g.setColor(Color.black);
        Fonts.DOGICAPIXEL.drawStringCentered(g, "Click to Return", (float) (x + width / 2), y + height / 2, 40);
    }

    @Override
    public void action() {
        TitleScreen.enterGame();
    }
}
