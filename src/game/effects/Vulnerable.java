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

    @Override
    public void apply() {
        target.modifyDefense(multiplier);
        durationLeft--;
    }


}
