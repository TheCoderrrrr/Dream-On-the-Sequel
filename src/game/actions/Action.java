package game.actions;

import game.effects.Effect;
import game.entity.Entity;
import org.newdawn.slick.Image;
import resources.Images;

import java.util.ArrayList;

public class Action {
    private final ArrayList<Effect> effects;
    private ArrayList<Effect> effectsGiven;
    protected String description;
    protected String name;
    protected Image symbol;

    public Action(ArrayList<Effect> effects) {
        this.effects = effects;
        description = "you forgor to add descirption";
        name = this.getClass().getSimpleName();
        symbol = Images.ENERGY0;
    }

    public void action(Entity target, Entity owner) {
        effectsGiven = new ArrayList<>();

        for(Effect e : effects) {
            Effect copy = e.copy();
            copy.setTarget(target);
            copy.setOwner(owner);
            copy.apply();
            effectsGiven.add(copy);
        }

        for(Effect e : effectsGiven) {
            target.applyEffect(e);
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
    public Image getSymbol(){
        return symbol;
    }

}
