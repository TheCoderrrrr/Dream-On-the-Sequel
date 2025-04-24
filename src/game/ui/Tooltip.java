package game.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Fonts;

import java.awt.*;

public class Tooltip extends Panel{
    public Tooltip() {
    }

    public void render(Graphics g, int x, int y, String info) {
        g.setColor(Color.white);
        g.fillRoundRect(x, y, 150, Fonts.EXO2.getHeight(g, info, 100, 15), 15);
        //g.fillRect(x, y, 150, Fonts.EXO2.getHeight(g, info , 50, 15));
        g.setColor(Color.black);
        Fonts.EXO2.wrap(g, info, 50, 50, 50, 15);
    }
}
