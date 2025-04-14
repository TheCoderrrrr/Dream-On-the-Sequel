package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import resources.Fonts;

public class FloatMessage extends Message{
    public FloatMessage(String text, float x, float y, Color color, int duration)
    {
        super(text, x, y, color, Fonts.EXO2, duration, true);
    }

    public void update()
    {
        super.update();
        y -= 0.5;
    }
}
