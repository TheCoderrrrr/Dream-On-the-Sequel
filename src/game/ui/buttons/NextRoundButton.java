package game.ui.buttons;

import game.World;
import game.managers.EntityManager;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import resources.Fonts;

public class NextRoundButton extends Button{
    EntityManager entityManager;
    public NextRoundButton(int x, int y, int width, int height, EntityManager entityManager) {
        super(x, y, width, height);
        this.entityManager = entityManager;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
        g.setColor(Color.black);
        g.drawRect(x, y, width, height);
        Fonts.DOGICAPIXEL.drawStringCentered(g, "Next Round", x + width / 2, y + height / 2, 30);
    }

    @Override
    public void action() {
        entityManager.newRound();
        World.roundBeginMode();
        System.out.println("NEXT ROUND CALLED");
    }
}
