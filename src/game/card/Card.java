package game.card;

import game.actions.Action;
import game.effects.Damage;
import game.effects.Effect;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
    protected boolean selected;
    protected static GameContainer gc;

    protected static final int CARD_WIDTH = 200;
    protected static final int CARD_HEIGHT = 300;

    public Card() {
        energyCost = 0;
        selected = false;
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
        if(!selected){
            g.drawImage(cardImage, x, y);
        }else{
            g.drawImage(cardImage, gc.getInput().getMouseX() - translationalX, gc.getInput().getMouseY() - translationalY);
        }

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
    public boolean isSelected(){
        return selected;
    }
    public void select(int x,int y){
        selected = true;
        originalX = this.x;
        originalY = this.y;
        translationalX = x - this.x;
        translationalY = y - this.y;
    }
    public void unselect(int x, int y){
        selected = false;
        this.x = x - translationalX;
        this.y = y - translationalY;
    }
    public void moveCard(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean isOver(int mX, int mY) {
        return x <= mX && x + CARD_WIDTH > mX && y <= mY && y + CARD_HEIGHT >= mY;
    }

}
