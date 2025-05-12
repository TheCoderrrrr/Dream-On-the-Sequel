package game.ui.panels;

import core.Main;
import game.World;
import game.managers.EntityManager;
import game.ui.buttons.CardSelectionButton;
import game.ui.buttons.GetRelicButton;
import game.ui.buttons.NextRoundButton;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import resources.Fonts;

public class RoundEndPanel extends Panel{
    private boolean getRelic = false;
    private boolean getCard = true;
    private GetRelicButton getRelicButton;
    private CardSelectionButton cardSelectionButton;
    private NextRoundButton nextRoundButton;
    private GameContainer gc;
    private int x = Main.getScreenWidth() / 2 - (int) (Main.getScreenWidth() * 0.125f);
    private int y = Main.getScreenHeight() / 2 - (int) (Main.getScreenHeight() * 0.2f);
    public RoundEndPanel(GameContainer gc, boolean getRelic, boolean getCard, EntityManager entityManager){
        this.gc = gc;
        width = (int) (Main.getScreenWidth() * 0.25f);
        height = (int) (Main.getScreenHeight() * 0.4f);
        this.getRelic = getRelic;
        this.getCard = getCard;
        if(getCard && cardSelectionButton == null) cardSelectionButton = new CardSelectionButton(x, (int) (y + height * 0.2), width, (int) (height * 0.2));
        if(getRelic) getRelicButton = new GetRelicButton(x, (int) (y+ height * 0.4), width, (int) (height * 0.2));
        nextRoundButton = new NextRoundButton(x, (int) (y + height - height * 0.2), width, (int) (height * 0.2), entityManager);
    }
    public void render(Graphics g){
        renderBackground(g);
        if(cardSelectionButton != null){
            cardSelectionButton.render(g);
        }
        if(getRelicButton != null){
            getRelicButton.render(g);
        }
        if(nextRoundButton != null){
            nextRoundButton.render(g);
        }
    }
    public void mousePressed(int button, int x, int y){
        if(cardSelectionButton != null && !cardSelectionButton.isUsed()){
            cardSelectionButton.mousePressed(button, x ,y);
        }
        if(getRelicButton != null && !getRelicButton.isUsed()){
            getRelicButton.mousePressed(button, x ,y);
        }
        if(nextRoundButton != null){
            nextRoundButton.mousePressed(button, x ,y);
        }
    }
    public void renderBackground(Graphics g){
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(0,0, Main.getScreenWidth(), Main.getScreenHeight());
        g.setColor(new Color(237,232,208, 200));
        g.fillRoundRect(x, y, width, height, 2, 3);
        g.setColor(Color.black);
        g.drawRoundRect(x, y, width, height, 2, 3);
        Fonts.DOGICAPIXEL.drawStringCentered(g, "Round " + World.getRound() + " Cleared", x + width/2, y + height / 10, 40);
    }
}
