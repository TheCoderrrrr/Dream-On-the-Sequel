package game.entity.enemy.boss;

import game.actions.enemyActions.godzillaActions.attack.*;
import game.actions.enemyActions.godzillaActions.buffing.AtomicRecharge;
import game.actions.enemyActions.godzillaActions.buffing.Fortitude;
import game.entity.enemy.Entity;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Godzilla extends Entity {

    public Godzilla(int maxHealth)
    {
        super(maxHealth);
        health = maxHealth;
        image = Images.GODZILLA;
        allMoves = new ArrayList<>(Arrays.asList(new Bite(), new LazerBeam(), new PlasmaRay(), new PoisonousBreath(), new Rapture(), new Slash(), new Tailwhip(), new AtomicRecharge(), new Fortitude()));
        this.initializeMoves();

    }

    protected void addMoves()
    {

    }
}
