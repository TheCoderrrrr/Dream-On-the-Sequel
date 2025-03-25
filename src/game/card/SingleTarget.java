package game.card;


import game.entity.Entity;

public interface SingleTarget {

    void use(Entity owner, Entity target);
}
