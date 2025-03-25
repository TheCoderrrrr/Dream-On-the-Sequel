package game.effects;
import resources.Images;

public class Vulnerable extends Effect{
    private float multiplier;

    public Vulnerable(float multiplier, int duration) {
        super(duration);
        this.multiplier = multiplier;
        name = "Vulnerable";
        symbol = Images.VULNERABLE;
        description = "Increases the damage taken by the affected enemy.";
    }

    public float getMultiplier() {
        if (multiplier == 1) {
            return .1f;
        } else if (multiplier == 2) {
            return .2f;
        } else if (multiplier == 3) {
            return .4f;
        } else {
            return .5f;
        }
    }

    @Override
    public void apply() {

    }


}
