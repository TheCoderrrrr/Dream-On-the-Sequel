package resources;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Sounds {
    public static Music BGMUSIC1;
    public static Music BGMUSIC2;
    public static Music BOSSMUSIC;
    public static Sound REEEEEEEEE;
    public static Sound GOOFY;
    public static Sound MUSICATTACK;
    public static Sound SLASH;
    public static Sound HEALING;
    public static Sound POISON;
    public static Sound SHIELD;
    public static Sound VULNERABLE;
    public static Sound BOSSBATTLE;
    public static Sound BURN;
    public static Sound DAMAGE;
    public static Sound WEAKEN;
    public static Sound MARK;
    public static Sound STRENGTH;

    public static void loadSounds()
    {
        try {
            REEEEEEEEE = new Sound("res/sounds/playcard.wav");
            GOOFY = new Sound("res/sounds/goofy.wav");
            MUSICATTACK = new Sound("res/sounds/musicAttack.wav");
            SLASH = new Sound("res/sounds/slash.wav");
            HEALING = new Sound("res/sounds/healing.wav");
            POISON = new Sound("res/sounds/poison.wav");
            SHIELD = new Sound("res/sounds/shield.wav");
            VULNERABLE = new Sound("res/sounds/vulnerable.wav");
            BOSSBATTLE = new Sound("res/sounds/bossbattlebegins.wav");
            BURN = new Sound("res/sounds/fire.wav");
            DAMAGE = new Sound("res/sounds/damage.wav");
            WEAKEN = new Sound("res/sounds/weaken.wav");
            MARK = new Sound("res/sounds/mark.wav");
            STRENGTH = new Sound("res/sounds/strength.wav");

        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
    public static void loadMusic()
    {
        try{
            BGMUSIC1 = new Music("res/music/bgmusic1.ogg");
            BGMUSIC2 = new Music("res/music/funMusic.ogg");
            BOSSMUSIC = new Music("res/music/bossMusic.ogg");
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
}
