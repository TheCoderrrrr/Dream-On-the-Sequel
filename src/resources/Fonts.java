package resources;

import org.newdawn.slick.SlickException;

public class Fonts {
    private static final int DEFAULT_FONT_SIZE = 256;
    public static TextFont MATCHA;
    public static TextFont SAZIGONE;
    public static TextFont WHETHERS;
    public static TextFont COFFEEHEALINGITALIC;
    public static TextFont DOGICAPIXEL;
    public static TextFont RETROGAMING;
    public static TextFont  REGULAR;

    public static TextFont CARROIS;

    public static TextFont EXO2;

    public static void loadFonts(){
        try{
            MATCHA = TextFont.fromTTF("res/fonts/Matcha.ttf", false, false);
            SAZIGONE = TextFont.fromTTF("res/fonts/Sazigone.otf", false, false);
            WHETHERS = TextFont.fromTTF("res/fonts/Whethers.ttf", false, false);
            COFFEEHEALINGITALIC = TextFont.fromTTF("res/fonts/CoffeeHealingItalic.ttf", false, false);
            RETROGAMING = TextFont.fromTTF("res/fonts/RetroGaming.ttf", false, false);
            DOGICAPIXEL = TextFont.fromTTF("res/fonts/dogicapixel.ttf", false, false);
            REGULAR = TextFont.fromTTF("res/fonts/Itim.ttf", false, false);
            CARROIS = TextFont.fromTTF("res/fonts/CarroisGothic.ttf", false, false);
            EXO2 = TextFont.fromTTF("res/fonts/Exo2.ttf", false, false);
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

}
