package game.effects;

import game.entity.Entity;
import resources.Images;

public class Poison extends Effect {
    private final int POISON_STRENGTH;


    public Poison(int poisonStrength, int duration) {
        super(duration);
        this.POISON_STRENGTH = poisonStrength;
        name = "Poisoned";
        symbol = Images.POISONED;
        description = "Deals " + POISON_STRENGTH + " damage every round for " + duration + " rounds.";
    }

    @Override
    public void action() {
        target.takeDamage(POISON_STRENGTH);
        durationLeft--;
    }
}
