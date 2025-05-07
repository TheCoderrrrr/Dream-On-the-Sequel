package game.card.bearCards.mutli.debuff;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.MultiTarget;
import game.effects.*;
import game.entity.Entity;
import game.managers.EntityManager;
import game.managers.HitBox;
import game.ui.panels.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class ComfortCurse extends Card implements MultiTarget, Attacking {
    public ComfortCurse()
    {
        super();
        energyCost = 2;
        name = "Comfort Curse";
        description = "Adds Vulnerability";
        cardImage = Images.COMFORT_CURSE;
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Vulnerable(1.5f, 3));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);

    }

    public void use(Entity owner)
    {
        for(HitBox hitBox : EntityManager.getHitBoxes()){
            if(hitBox.hasEntity()){
                for(Effect effect : action.getEffects()) {
                    effect.setOwner(owner);
                    effect.setTarget(hitBox.getEntity());
                }
                for(Effect effect : action.getEffects()) {
                    effect.apply();
                }
            }
        }

    }
}
