package game.entity.enemy;

import game.actions.enemyActions.horseActions.attacking.HoofStomp;
import game.actions.enemyActions.horseActions.attacking.ManeDash;
import game.actions.enemyActions.horseActions.attacking.NeighQuake;
import game.actions.enemyActions.horseActions.attacking.WildWhinny;
import resources.Images;

import java.util.ArrayList;
import java.util.Arrays;

public class Horse extends Enemy {
    public Horse()
    {
        super(75);
        image = Images.ENEMY2;
        allMoves = new ArrayList<>(Arrays.asList(new HoofStomp(), new ManeDash(), new NeighQuake(), new WildWhinny()));
        super.initializeMoves();
    }
}
