package game.card.bearCards.mutli.attack;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.MultiTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.entity.Entity;
import game.managers.EntityManager;
import game.managers.HitBox;
import game.ui.panels.CardEffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class ButtonBarrage extends Card implements MultiTarget, Attacking {
    public ButtonBarrage()
    {
        super();
        energyCost = 1;
        name = "Button Barrage";
        cardImage = Images.BUTTON_BARRAGE;
        description = "Attacks with buttons among 3 enemies dealing 20 dmg";
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Damage(20));
        action = new Action(actions);
        effectsPanel = new CardEffectsPanel(actions);
    }
    public void use(Entity owner) {
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
