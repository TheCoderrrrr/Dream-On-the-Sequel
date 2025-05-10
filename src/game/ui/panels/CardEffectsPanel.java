package game.ui.panels;

import core.Main;
import game.effects.Damage;
import game.effects.Effect;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Fonts;

import java.util.ArrayList;

public class CardEffectsPanel extends Panel {
    ArrayList<Effect> effects;
    private final int width = (int) (Main.getScreenWidth() * 0.08);
    private final int padding = (int) (Main.getScreenWidth() * 0.001);
    private int startingHeight = 0;

    public CardEffectsPanel(ArrayList<Effect> effects) {
        this.effects = effects;
    }

    public void render(Graphics g, int x, int y) {
        startingHeight = y;

        for (int i = 0; i < effects.size(); i++) {
            Effect effect = effects.get(i);
            if (!(effect instanceof Damage)) {
                renderSingleEffect(g, effect, x + padding, startingHeight);
            }
        }
    }

    public void renderSingleEffect(Graphics g, Effect effect, int x, int y) {
        float height = 0;
        float offset = Fonts.RETROGAMING.getHeight(g, effect.getName(), width, 20) + Fonts.RETROGAMING.getHeight(g, " ", width, 5);
        height += offset;
        height += Fonts.RETROGAMING.getHeight(g, effect.getDescription(), width, 20);

        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
        g.setColor(Color.white);

        startingHeight += height + padding;

        Fonts.RETROGAMING.wrap(g, effect.getName(), x, y, width, 20);
        Fonts.EXO2.wrap(g, effect.getDescription(), x, y + offset, width, 20);
    }
}
