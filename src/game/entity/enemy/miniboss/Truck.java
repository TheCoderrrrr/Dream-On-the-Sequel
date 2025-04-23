package game.entity.enemy.miniboss;

import game.actions.enemyActions.truckActions.attacking.CargoCover;
import game.actions.enemyActions.truckActions.attacking.Crush;
import game.actions.enemyActions.truckActions.attacking.RamSlam;
import game.actions.enemyActions.truckActions.attacking.TurboTakedown;
import game.actions.enemyActions.truckActions.buffing.PitStop;
import game.entity.enemy.Enemy;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Truck extends Enemy {
    public Truck(int maxHealth)
    {
        super(maxHealth *= 2);
        image = Images.TRUCKENEMY;
        allMoves = new ArrayList<>(Arrays.asList(new CargoCover(), new Crush(), new RamSlam(), new TurboTakedown(), new PitStop()));
        this.initializeMoves();
    }

    protected void addMoves()
    {

    }
}
