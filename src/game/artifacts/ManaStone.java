package game.artifacts;

import game.effects.Effect;
import game.effects.Shield;
import game.entity.player.Player;
import game.managers.CardManager;
import resources.Images;

import java.util.ArrayList;
import java.util.List;

///at the beginning of each turn, gain 1 energy
public class ManaStone extends Artifact{

    public ManaStone() {
        super(null, null, null);
        image = Images.RELIC2;
    }

    public void turnStartEffects(Player p) {
        super.turnStartEffects(p);
        CardManager.gainEnergy(1);
    }
}
