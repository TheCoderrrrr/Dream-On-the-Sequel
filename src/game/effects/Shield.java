package game.effects;

import game.entity.Entity;
import resources.Images;

public class Shield extends Effect{
    private int multiplier;
    public Shield(int amount, int duration) {
        super(duration);
        this.multiplier = amount;
        name = "Shield";
        symbol = Images.SHIELD;
        description = "Blocks the next enemy's attack.";
    }
    public float getMultiplier()
    {
        if(multiplier == 1){
            return 1 -.25f;
        }else if(multiplier == 2){
            return 1 -.5f;
        } else if(multiplier == 3){
            return 1 -.75f;
        }
        else {
            return 0;
        }
    }

    @Override
    public void action() {

    }
}
