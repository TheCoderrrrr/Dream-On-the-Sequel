package game.artifacts;

import game.effects.Effect;
import game.entity.player.Player;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Artifact {
    protected ArrayList<Effect> cardUsedEffects;
    protected ArrayList<Effect> damageTakenEffects;
    protected ArrayList<Effect> turnStartEffects;

    public Artifact(ArrayList<Effect> cardUsedEffects, ArrayList<Effect> damageTakenEffects, ArrayList<Effect> turnStartEffects) {
        this.cardUsedEffects = Objects.requireNonNullElseGet(cardUsedEffects, ArrayList::new);
        this.damageTakenEffects = Objects.requireNonNullElseGet(damageTakenEffects, ArrayList::new);
        this.turnStartEffects = Objects.requireNonNullElseGet(turnStartEffects, ArrayList::new);
    }

    public void damageTakenEffect(Player p) {
        for(Effect e : damageTakenEffects) {
            e.setTarget(p);
            e.apply();
        }
        if(!damageTakenEffects.isEmpty()) {
            System.out.println(this + " activated damage taken effect");
        }

    }

    public void cardUsedEffect(Player p) {
        for(Effect e : cardUsedEffects) {
            e.setTarget(p);
            e.apply();
        }
        if(!cardUsedEffects.isEmpty()) {
            System.out.println(this + " activated card used effect");
        }

    }

    public void turnStartEffects(Player p) {
        for(Effect e : turnStartEffects) {
            e.setTarget(p);
            e.apply();
        }
        if(!turnStartEffects.isEmpty()) {
            System.out.println(this + " activated turn start effect");
        }

    }

}
