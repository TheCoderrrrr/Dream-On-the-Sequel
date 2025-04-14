package game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import resources.Fonts;
import resources.TextFont;

public class Message {
    protected String text;
    protected float x;
    protected float y;
    protected Color color;
    protected TextFont font;
    public int duration;
    public int timeLeft;
    public boolean fading;

    public Message(String text, float x, float y, Color color, TextFont font)
    {
        this(text, x, y, color, font, -1, true);

    }

    public Message(String text, float x, float y)
    {
        this (text, x, y, Color.red, Fonts.EXO2);
    }

    public Message(String text, float x, float y, Color color, TextFont font, int duration, boolean fading) {
        this.text = text;
        this.x = x;
        this.color = color;
        this.font = font;
        this.duration = duration;
        timeLeft = duration;
        this.fading = fading;
    }

    public int getDuration()
    {
        return duration;
    }

    public int getTimeLeft()
    {
        return timeLeft;
    }

    public void update()
    {
        if(timeLeft > 0)
        {
            fading = true;
            timeLeft--;
        }
        else{
            fading = false;
        }
    }

    public float getPercentTimeLeft()
    {
        return (float) timeLeft / duration;
    }

    public void render(Graphics g)
    {
        if(fading)
        {
            color = new Color (color.getRed(), color.getGreen(), color.getBlue(), getPercentTimeLeft());
            font.drawString(g, text, x, y, 100);
            g.setColor(color);
            g.drawString("-" + text, x, y);

        }
    }

//    protected void centerText()
//    {
//        x = x - font.getWidth(text)/2;
//    }
}
