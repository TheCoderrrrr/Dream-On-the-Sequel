package game.effects;
import resources.Images;
import resources.Sounds;

public class Vulnerable extends Effect{
    private float multiplier;

    public Vulnerable(float multiplier, int duration) {
        super(duration);
        this.multiplier = multiplier;
        name = "Vulnerable";
        symbol = Images.VULNERABLE;
        description = "Increases the damage taken by the affected enemy.";
    }

    public Vulnerable copy() {
        return new Vulnerable(multiplier, duration);
    }

    @Override
    public void apply() {
        Sounds.VULNERABLE.play();
        target.modifyDefense(multiplier);
        durationLeft--;
    }


}
