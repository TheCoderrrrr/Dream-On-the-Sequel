package game.ui;

import game.effects.Damage;
import game.effects.Effect;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class EffectsPanel extends Panel{
    private ArrayList<Effect> curEffects;
    public EffectsPanel(){
        curEffects = new ArrayList<>();
        tooltip = new Tooltip();
    }
    public void updateEffects(ArrayList<Effect> effects)
    {
        curEffects = effects;
        for(int i = curEffects.size() - 1; i > 0; i--){
            if(curEffects.get(i) instanceof Damage){
                curEffects.remove(i);
            }
        }
    }
    public void render(Graphics g, int x, int y) {
        int width = 3;
        int size = curEffects.size();

        if (size == 0) {
            return;
        }

        int height = (int) Math.ceil((double) size / width);
        this.height = height * curEffects.getFirst().getSymbol().getHeight();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = i * width + j;
                if (index >= size) {
                    return;
                }

                Effect effect = curEffects.get(index);
                g.drawImage(
                        effect.getSymbol(),
                        x + j * effect.getSymbol().getWidth(),
                        y + i * effect.getSymbol().getHeight()
                );
                int effectX = x + j * effect.getSymbol().getWidth();
                int effectY = y + i * effect.getSymbol().getHeight();
                int effectWidth = effect.getSymbol().getWidth();
                int effectHeight = effect.getSymbol().getHeight();

                g.drawImage(effect.getSymbol(), effectX, effectY);

                if (gc.getInput().getMouseX() >= effectX && gc.getInput().getMouseX() <= effectX + effectWidth &&
                        gc.getInput().getMouseY() >= effectY && gc.getInput().getMouseY() <= effectY + effectHeight) {

                    tooltip.render(g, gc.getInput().getMouseX(), gc.getInput().getMouseY(), effect.getDescription());
                }
            }
        }
    }
}
