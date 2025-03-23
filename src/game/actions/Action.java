package game.actions;

import game.effects.Effect;

import java.util.ArrayList;

public abstract class Action {
    private final ArrayList<Effect> effects;

    public Action(ArrayList<Effect> effects) {
        this.effects = effects;
    }

    public void action() {
        for(Effect e : effects) {
            e.action();
        }
    }
    public ArrayList<Effect> getEffects(){
        return effects;
    }

}
