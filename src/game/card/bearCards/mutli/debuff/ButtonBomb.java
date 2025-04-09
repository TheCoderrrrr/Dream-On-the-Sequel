package game.card.bearCards.mutli.debuff;

import game.actions.Action;
import game.card.Attacking;
import game.card.Card;
import game.card.MultiTarget;
import game.effects.Damage;
import game.effects.Effect;
import game.effects.Mark;
import game.entity.Entity;
import game.managers.EntityManager;
import game.managers.HitBox;
import game.ui.EffectsPanel;
import resources.Images;

import java.util.ArrayList;

public class ButtonBomb extends Card implements MultiTarget, Attacking {
    public ButtonBomb()
    {
        super();
        energyCost = 2;
        name = "Button Bomb";
        description = "Adds Mark Effect";
        cardImage = Images.BUTTON_BOMB;
        ArrayList<Effect> actions = new ArrayList<>();
        actions.add(new Mark(1.5f, 2));
        action = new Action(actions);
        effectsPanel = new EffectsPanel(actions);
    }

    public void use(Entity owner)
    {
        for(HitBox hitBox : EntityManager.getHitBoxes()){
            if(hitBox.hasEnemy()){
                for(Effect effect : action.getEffects()) {
                    effect.setOwner(owner);
                    effect.setTarget(hitBox.getEnemy());
                }
                for(Effect effect : action.getEffects()) {
                    effect.apply();
                }
            }
        }
    }
}
