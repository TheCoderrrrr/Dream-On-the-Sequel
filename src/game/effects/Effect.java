package game.effects;

import game.entity.Entity;
import org.newdawn.slick.Image;

abstract public class Effect {
    protected Entity owner;
    protected Entity target;
    protected final int duration;
    protected int durationLeft;
    protected String name;
    protected String description;
    protected Image symbol;

    public Effect(int duration) {
        this.duration = duration;
        durationLeft = duration;
        name = "";
        description = "nothin";
    }

    public void setTarget(Entity target) {
        this.target = target;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public final boolean isExpired() {
        return durationLeft == 0;
    }

    abstract public void apply();
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
}
