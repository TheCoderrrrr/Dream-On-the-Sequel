package game.artifacts;

import game.effects.Shield;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

///every time you are hit increase block% by 10
public class Bulwark extends Artifact{

    public Bulwark() {
        super(null, new ArrayList<>(List.of(new Shield(0.1f, 1))), null);
        image = Images.RELIC1;
        name = "Bulwark";
        description = "Increases block by 10% per each hit taken.";
    }

}
