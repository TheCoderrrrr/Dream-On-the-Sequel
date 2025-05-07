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


public class StuffedSorrow extends Card implements MultiTarget, Attacking {
    public StuffedSorrow()
    {
        super();
        energyCost = 3;
        name = "Stuffed Sorrow";
        description = "Decrease Enemy Attack by 20% for 1 round";
        cardImage = Images.STUFFED_SORROW;
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Weaken(.20f, 1));
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
