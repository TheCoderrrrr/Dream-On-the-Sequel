package game.ui.buttons;

import game.managers.EntityManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class NextRoundButton extends Button{
    EntityManager entityManager;
    public NextRoundButton(int x, int y, int width, int height, EntityManager entityManager) {
        super(x, y, width, height);
        this.entityManager = entityManager;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRoundRect(x, y, width, height, 2, 2);
    }

    @Override
    public void action() {
        entityManager.newRound();
        System.out.println("NEXT ROUND CALLED");
    }
}
