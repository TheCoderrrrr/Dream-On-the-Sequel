package game.ui.buttons;

import game.World;
import org.newdawn.slick.Graphics;
import resources.Images;

public class EndTurnButton extends Button{
    public EndTurnButton(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void action() {
        if(World.isMyTurn()){
            World.startEnemyTurn();
        }
    }

    @Override
    public void render(Graphics g) {
        if (World.getRound() < 15) {
            g.drawImage(Images.NORMAL_ENDTURN.getScaledCopy(width, height), x, y);
        }

        if (World.getRound() == 15)
        {
            g.drawImage(Images.BOSS_ENDTURN.getScaledCopy(width, height), x, y);
        }

        g.setLineWidth(4);
        g.drawRect(x, y, width, height);
        g.setLineWidth(1);
    }
}
