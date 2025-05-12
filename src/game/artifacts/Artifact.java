package game.artifacts;

import game.effects.Effect;
import game.entity.player.Player;
import game.ui.panels.ArtifactInfoPanel;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Images;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Artifact {
    protected ArrayList<Effect> cardUsedEffects;
    protected ArrayList<Effect> damageTakenEffects;
    protected ArrayList<Effect> turnStartEffects;
    protected String name;
    protected String description;
    protected Image image;
    protected ArtifactInfoPanel infoPanel;

    public Artifact(ArrayList<Effect> cardUsedEffects, ArrayList<Effect> damageTakenEffects, ArrayList<Effect> turnStartEffects) {
        this.cardUsedEffects = Objects.requireNonNullElseGet(cardUsedEffects, ArrayList::new);
        this.damageTakenEffects = Objects.requireNonNullElseGet(damageTakenEffects, ArrayList::new);
        this.turnStartEffects = Objects.requireNonNullElseGet(turnStartEffects, ArrayList::new);
        name = "didnt give name";
        description = "didnt give discription";
        image = Images.ENERGY0;
        infoPanel = new ArtifactInfoPanel();
    }

    public void damageTakenEffect(Player p) {
        for (Effect e : damageTakenEffects) {
            e.setTarget(p);
            e.apply();
        }
        if (!damageTakenEffects.isEmpty()) {
            System.out.println(this + " activated damage taken effect");
        }
    }

    public void cardUsedEffect(Player p) {
        for (Effect e : cardUsedEffects) {
            e.setTarget(p);
            e.apply();
        }
        if (!cardUsedEffects.isEmpty()) {
            System.out.println(this + " activated card used effect");
        }

    }

    public void turnStartEffects(Player p) {
        for (Effect e : turnStartEffects) {
            e.setTarget(p);
            e.apply();
        }
        if (!turnStartEffects.isEmpty()) {
            System.out.println(this + " activated turn start effect");
        }

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x, y);
    }

    public ArrayList<Effect> getEffects() {
        if (!cardUsedEffects.isEmpty()) {
            return cardUsedEffects;
        } else if (!damageTakenEffects.isEmpty()) {
            return damageTakenEffects;
        } else if (!turnStartEffects.isEmpty()) {
            return turnStartEffects;
        } else {
            return null;
        }
    }
    public Image getImage(){
        return image;
    }
    public String getDescription(){
        return description;
    }
    public String getName(){
        return name;
    }

}
