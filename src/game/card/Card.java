package game.card;

import core.Main;
import game.actions.Action;
import game.effects.Damage;
import game.effects.Effect;
import game.ui.panels.CardEffectsPanel;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Fonts;
import resources.Images;

import java.util.ArrayList;

abstract public class Card {
    protected Action action;
    protected Action selfDamaging;
    protected String name;
    protected String description;
    protected int energyCost;
    protected Image cardImage;
    protected Image energyCostImage;
    protected int x;
    protected int y;
    protected int originalX;
    protected int originalY;
    protected int translationalX;
    protected int translationalY;
    protected boolean dragging;
    protected boolean isUsed;
    protected static GameContainer gc;
    protected CardEffectsPanel effectsPanel;
    protected boolean outlined;
    protected static final int CARD_WIDTH = (int) (Main.getScreenWidth() / 9.6);
    protected static final int CARD_HEIGHT = (int) (Main.getScreenHeight() / 3.6);
    protected static final int UPSCALED_CARD_WIDTH = (int) (Main.getScreenWidth() / 9.6 * 1.2);
    protected static final int UPSCALED_CARD_HEIGHT = (int) (Main.getScreenHeight() / 3.6 * 1.2);
    protected int cardWidth = CARD_WIDTH;
    protected int cardHeight = CARD_HEIGHT;
    protected float scaler = 1;

    public Card() {
        energyCost = 0;
        dragging = false;
        isUsed = false;
        outlined = false;
        updateEnergyImage();
    }

    public static void setGC(GameContainer gc) {
        Card.gc = gc;
    }

    public void updateEnergyImage() {
        switch (energyCost) {
            case 0:
                energyCostImage = Images.ENERGY0;
                break;
            case 1:
                energyCostImage = Images.ENERGY1;
                break;
            case 2:
                energyCostImage = Images.ENERGY2;
                break;
            case 3:
                energyCostImage = Images.ENERGY3;
                break;
            case 4:
                energyCostImage = Images.ENERGY4;
                break;
            default:
                energyCostImage = Images.ENERGY0;
                System.out.println("No energy cost put in " + this.getClass().getSimpleName());
        }
    }

    public void markAsUsed() {
        isUsed = true;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void update() {
        updateEnergyImage();
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        cardImage = cardImage.getScaledCopy(cardWidth, cardHeight);
        if (dragging) {
            g.drawImage(cardImage, gc.getInput().getMouseX() - translationalX, gc.getInput().getMouseY() - translationalY);
            renderDescription(g, gc.getInput().getMouseX() - translationalX, (gc.getInput().getMouseY() - translationalY));
            renderName(g, (float) (gc.getInput().getMouseX() - translationalX + (cardWidth * 0.05)), (float) (gc.getInput().getMouseY() - translationalY + cardHeight * 0.02));
            renderEnergyCost(g, gc.getInput().getMouseX() - translationalX + cardWidth - (float) energyCostImage.getWidth(), gc.getInput().getMouseY() - translationalY + (float) energyCostImage.getHeight() / 5);

        } else {
            g.drawImage(cardImage, x, y);
            renderDescription(g, x, y);
            renderName(g, (float) (x + (cardWidth * 0.05)), (float) (y + cardHeight * 0.02));
            renderEnergyCost(g, x + cardWidth - (float) energyCostImage.getWidth(), y + (float) energyCostImage.getHeight() / 5);
        }
        if(outlined) {
            g.setColor(Color.white);
            g.drawRect(x - 5, y - 5, cardWidth + 10, cardHeight + 10);
        }

    }

    public void render(int x, int y, Graphics g) {
        x -= cardWidth/2;
        y -= cardHeight/2;
        g.drawImage(cardImage, x, y);
        renderDescription(g, x, y);
        renderName(g, (float) (x + (cardWidth * 0.05)), (float) (y + cardHeight * 0.02));
        renderEnergyCost(g, x + cardWidth - (float) energyCostImage.getWidth(), y + (float) energyCostImage.getHeight() / 5);
        if(outlined) {
            g.setColor(Color.white);
            g.drawRect(x - 5, y - 5, cardWidth + 10, cardHeight + 10);
        }
    }

    public void renderDescription(Graphics g, float x, float y) {
        Fonts.RETROGAMING.wrap(g, description, (float) (x + cardWidth * 0.05), (float) (y + cardHeight * 0.7), cardWidth - 10, 15 * scaler);
    }

    public void renderName(Graphics g, float x, float y) {
        Fonts.REGULAR.drawString(g, name, x, y,15 * scaler);
//        g.drawString(name, x, y);
    }

    public void renderEnergyCost(Graphics g, float x, float y) {
        updateEnergyImage();
        energyCostImage = energyCostImage.getScaledCopy(scaler);
        g.drawImage(energyCostImage, x, y);
    }

    public void renderEffectsPanel(Graphics g, ArrayList<Card> cards) {
        if (effectsPanel != null) {
            if (dragging) {
                effectsPanel.render(g, gc.getInput().getMouseX() - translationalX + getCardWidth(), (gc.getInput().getMouseY() - translationalY));
            } else {
                boolean render = true;
                for (Card c : cards) {
                    if (c.isDragging()) {
                        render = false;
                    }
                }
                if (isOver(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && render) {
                    effectsPanel.render(g, x + getCardWidth(), y);
                }
            }
        }
    }

    public int getCardWidth() {
        return cardWidth;
    }

    public int getCardLength() {
        return cardHeight;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public Action getAction() {
        return action;
    }

    public ArrayList<Effect> getEffects() {
        ArrayList<Effect> actualEffects = new ArrayList<>();
        for (Effect e : action.getEffects()) {
            if (!(e instanceof Damage)) {
                actualEffects.add(e);
            }
        }
        return actualEffects;
    }

    public boolean isDragging() {
        return dragging;
    }

    public void drag(int x, int y) {
        dragging = true;
        translationalX = x - this.x;
        translationalY = y - this.y;
    }

    public void reslot() {
        dragging = false;
        this.x = originalX;
        this.y = originalY;
    }

    public void initializePosition(int x, int y) {
        originalX = x;
        originalY = y;
        this.x = x;
        this.y = y;
    }

    public boolean isOver(int mX, int mY) {
        return x <= mX && x + cardWidth > mX && y <= mY && y + cardHeight >= mY;
    }

    public void unuse() {
        isUsed = false;
    }

    public void hoveredPos() {
        cardWidth = UPSCALED_CARD_WIDTH;
        cardHeight = UPSCALED_CARD_HEIGHT;
        scaler = 1.2f;
        y = Main.getScreenHeight() - cardHeight;
    }

    public void defaultPos() {
        cardWidth = CARD_WIDTH;
        cardHeight = CARD_HEIGHT;
        scaler = 1;
        y = Main.getScreenHeight() - cardHeight;
    }
    public void outline() {
        outlined = true;
        System.out.println("outluined");
    }

    public void unoutline() {
        outlined = false;
    }
    public boolean isOutlined(){
        return outlined;
    }
}
