package game.card;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Effect;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import resources.Fonts;
import resources.Images;

import java.util.ArrayList;

abstract public class Card {
    protected Action action;
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
    protected static GameContainer gc;

    protected static final int CARD_WIDTH = 200;
    protected static final int CARD_HEIGHT = 300;

    public Card() {
        energyCost = 0;
        dragging = false;
        updateEnergyImage();
    }
    public static void setGC(GameContainer gc){
        Card.gc = gc;
    }
    public void updateEnergyImage(){
        switch (energyCost){
            case 0 :
                energyCostImage = Images.ENERGY0;
                break;
            case 1 :
                energyCostImage = Images.ENERGY1;
                break;
            case 2 :
                energyCostImage = Images.ENERGY2;
                break;
            case 3 :
                energyCostImage = Images.ENERGY3;
                break;
            case 4 :
                energyCostImage = Images.ENERGY4;
                break;
            default :
                energyCostImage = Images.ENERGY0;
                System.out.println("No energy cost put in " + this.getClass().getSimpleName());
        }
    }
    public void update(){
        updateEnergyImage();
    }
    public void render(Graphics g){
        if(dragging){

            g.drawImage(cardImage, gc.getInput().getMouseX() - translationalX, gc.getInput().getMouseY() - translationalY);
            renderDescription(g, gc.getInput().getMouseX() - translationalX, (gc.getInput().getMouseY() - translationalY));
            renderName(g, (float) (gc.getInput().getMouseX() - translationalX + (CARD_WIDTH * 0.05)), (float) (gc.getInput().getMouseY() - translationalY + CARD_HEIGHT * 0.02));
            renderEnergyCost(g, gc.getInput().getMouseX() - translationalX + CARD_WIDTH - (float) energyCostImage.getWidth(), gc.getInput().getMouseY() - translationalY + (float) energyCostImage.getHeight()/5);

        }else{

            g.drawImage(cardImage, x, y);
            renderDescription(g, x, y);
            renderName(g, (float) (x + (CARD_WIDTH * 0.05)), (float) (y + CARD_HEIGHT * 0.02));
            renderEnergyCost(g, x + CARD_WIDTH - (float) energyCostImage.getWidth(), y + (float) energyCostImage.getHeight()/5);
        }

    }
    public void renderDescription(Graphics g, float x, float y){
        Fonts.RETROGAMING.wrap(g, description, (float) (x + CARD_WIDTH * 0.05), (float) (y + CARD_HEIGHT * 0.7), CARD_WIDTH - 10, 15);
    }
    public void renderName(Graphics g, float x, float y){
        g.drawString(name, x, y);
    }
    public void renderEnergyCost(Graphics g, float x, float y){
        updateEnergyImage();
        g.drawImage(energyCostImage, x, y);
    }
    public static int getCardWidth(){
        return CARD_WIDTH;
    }
    public static int getCardLength(){
        return CARD_HEIGHT;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public int getEnergyCost(){
        return energyCost;
    }
    public Action getAction() {
        return action;
    }
    public ArrayList<Effect> getEffects(){
        ArrayList<Effect> actualEffects = new ArrayList<>();
        for(Effect e : action.getEffects()){
            if(!(e instanceof Damage)){
                actualEffects.add(e);
            }
        }
        return actualEffects;
    }
    public boolean isDragging(){
        return dragging;
    }
    public void drag(int x, int y){
        dragging = true;
        translationalX = x - this.x;
        translationalY = y - this.y;
    }
    public void reslot(int x, int y){
        dragging = false;
        this.x = originalX;
        this.y = originalY;
    }
    public void initializePosition(int x, int y){
        originalX = x;
        originalY = y;
        this.x = x;
        this.y = y;
    }
    public boolean isOver(int mX, int mY) {
        return x <= mX && x + CARD_WIDTH > mX && y <= mY && y + CARD_HEIGHT >= mY;
    }

}
