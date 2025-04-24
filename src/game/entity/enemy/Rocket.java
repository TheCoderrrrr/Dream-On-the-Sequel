package game.entity.enemy;

import game.actions.enemyActions.rocketActions.attacks.BlastOff;
import game.actions.enemyActions.rocketActions.attacks.Strike;
import game.actions.enemyActions.rocketActions.buffing.Cooldown;
import game.actions.enemyActions.rocketActions.buffing.CrewSupport;
import game.actions.enemyActions.rocketActions.buffing.FiringUp;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Rocket extends Enemy{
    public Rocket(int maxHealth)
    {
        super(maxHealth);
        image = Images.ROCKET;
        allMoves = new ArrayList<>(Arrays.asList(new BlastOff(), new Strike(), new Cooldown(), new CrewSupport(), new FiringUp()));
        this.initializeMoves();
    }
}
