package game.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Fonts;

import java.awt.*;

public class Tooltip extends Panel{
    public Tooltip() {
    }

    public void render(Graphics g, int x, int y, String info) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 50, Fonts.DOGICAPIXEL.getHeight(g, info , 50, 15));
        g.setColor(Color.black);
        Fonts.DOGICAPIXEL.wrap(g, info, x, y, 50, 15);
    }
}
