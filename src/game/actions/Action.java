package game.actions;

import game.effects.Effect;
import game.entity.Entity;

import java.util.ArrayList;

public class Action {
    private final ArrayList<Effect> effects;
    protected String description;
    protected String name;

    public Action(ArrayList<Effect> effects) {
        this.effects = effects;
        description = "you forgor to add descirption";
        name = this.getClass().getSimpleName();
    }

    public void action(Entity target, Entity owner) {
        for(Effect e : effects) {
            e.setTarget(target);
            e.setOwner(owner);
            e.apply();
        }
    }
    public ArrayList<Effect> getEffects(){
        return effects;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }

}
