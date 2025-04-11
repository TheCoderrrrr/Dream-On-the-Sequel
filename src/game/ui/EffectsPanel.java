package game.ui;

import game.effects.Damage;
import game.effects.Effect;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Fonts;

import java.awt.*;
import java.util.ArrayList;

public class EffectsPanel extends Panel {
    ArrayList<Effect> effects;

    public EffectsPanel(ArrayList<Effect> effects) {
        this.effects = effects;
    }

    public void render(Graphics g, int x, int y) {
        int width = 200;

        for (int i = 0; i < effects.size(); i++) {
            Effect effect = effects.get(i);
            if (effect instanceof Damage) {
                continue;
            } else {
                renderSingleEffect(g, effect, x + width * i, y);
            }
        }
    }

    public void renderSingleEffect(Graphics g, Effect effect, int x, int y) {
        int width = 200;
        float height = 0;
        float offset = Fonts.RETROGAMING.getHeight(g, effect.getName(), width, 20) + Fonts.RETROGAMING.getHeight(g, " ", width, 5);
        height += offset;
        height += Fonts.RETROGAMING.getHeight(g, effect.getDescription(), width, 20);

        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);

        Fonts.RETROGAMING.wrap(g, effect.getName(), x, y, width, 20);
        Fonts.EXO2.wrap(g, effect.getDescription(), x, y + offset, width, 20);
    }
}
