package game.effects;

import game.entity.Entity;
import org.newdawn.slick.Image;
import resources.Images;

abstract public class Effect {
    protected Entity owner;
    protected Entity target;
    protected final int duration;
    protected int durationLeft;
    protected String name;
    protected String description;
    protected Image symbol;
    protected int stack = 1;

    public Effect(int duration) {
        this.duration = duration;
        durationLeft = duration;
        name = "";
        symbol = Images.ENERGY0;
        description = "nothin";
    }

    abstract public Effect copy();

    public void setTarget(Entity target) {
        this.target = target;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public final boolean isExpired() {
        return durationLeft <= 0;
    }

    ///only call this ability if the effect acts IMMEDIATELY, not when a turn ends(like poison or burn)
    abstract public void apply();
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getDurationLeft(){
        return durationLeft;
    }
    public Image getSymbol(){
        return symbol;
    }
    public void increaseStack(){
        stack++;
    }
    public void resetDuration(int duration){
        durationLeft = duration;
    }
}
