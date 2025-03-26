package game.entity.enemy;

import game.actions.enemyActions.soldierActions.attacking.BombSurprise;
import game.actions.enemyActions.soldierActions.attacking.SniperShot;
import game.actions.enemyActions.soldierActions.attacking.Strike;
import game.actions.enemyActions.soldierActions.attacking.VolleyFire;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Soldier extends Enemy{
    public Soldier(int maxHealth)
    {
        super(maxHealth);
        image = Images.ENEMY1;
        allMoves = new ArrayList<>(Arrays.asList(new BombSurprise(), new SniperShot(), new Strike(), new VolleyFire()));
        this.initializeMoves();
    }

    protected void addMoves()
    {

    }

}
