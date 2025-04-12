package game.effects;

import game.entity.Entity;
import resources.Images;

public class Poison extends Effect {
    private final int poisonStrength;


    public Poison(int poisonStrength, int duration) {
        super(duration);
        this.poisonStrength = poisonStrength;
        name = "Poisoned";
        symbol = Images.POISONED;
        description = "Deals " + poisonStrength + " damage every round for " + duration + " rounds.";
    }

    public Poison copy() {
        return new Poison(poisonStrength, duration);
    }

    @Override
    public void apply() {
        target.takeDamage(poisonStrength);
        durationLeft--;
    }
}
