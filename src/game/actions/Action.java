package game.actions;

import game.effects.Effect;

import java.util.ArrayList;

public abstract class Action {
    private final ArrayList<Effect> effects;
    protected String description;
    protected String name;

    public Action(ArrayList<Effect> effects) {
        this.effects = effects;
        description = "you forgor to add descirption";
        name = this.getClass().getSimpleName();
    }

    public void action() {
        for(Effect e : effects) {
            e.action();
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
