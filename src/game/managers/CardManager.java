package game.managers;

import core.Main;
import game.World;
import game.card.Attacking;
import game.card.Buffing;
import game.card.Card;
import game.card.bearCards.buff.*;
import game.card.bearCards.mutli.attack.NeedleToss;
import game.card.bearCards.mutli.debuff.ButtonBomb;
import game.card.bearCards.single.attack.BearBite;
import game.card.bearCards.single.attack.BearHug;
import game.card.bearCards.single.attack.PawCrush;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;

public class CardManager {
    private static final int HAND_SIZE = 5;
    private static boolean selectionMode;
    private static int totalCardWidth;
    private static int totalEnergy;
    private static int maximumEnergy;

    private static ArrayList<Card> hand;
    private static ArrayList<Card> deck;

    private EntityManager entityManager;

    public CardManager(GameContainer gc) {
        Card.setGC(gc);
        hand = new ArrayList<>();
        deck = new ArrayList<>();

        selectionMode = false;
        totalEnergy = 4;
        maximumEnergy = totalEnergy;

        deck.add(new BearBite());
        deck.add(new BearHug());
        deck.add(new WarmEmbrace());
        deck.add(new PawCrush());
        deck.add(new ButtonBomb());

        resetHand();

    }

    public void setEntityManager(EntityManager e) {
        this.entityManager = e;
    }

    public static void update() {
        for(int i=hand.size() - 1; i>=0; i--) {
            if(hand.get(i).isUsed()) {
                hand.get(i).unuse();
                deck.add(hand.remove(i));
            }
        }
        updateTotalCardWidth();
        initializeHand();
    }

    public static void render(Graphics g) {
        for (Card c : hand) {
            if(!c.isDragging()) {
                c.render(g);

            }
        }
        for (Card c : hand) {
            if(c.isDragging())
            {
                if(c instanceof Buffing){
                    g.fillRect(Main.getScreenWidth() / 2, Main.getScreenHeight() / 2, 200, 200);
                }else if(c instanceof Attacking){
                    for(HitBox h : EntityManager.getHitBoxes()){
                        if(h.hasEnemy()){
                            h.renderHitBox(g);
                        }
                    }
                }
                c.render(g);
            }
        }
        for(Card c : hand){
            c.renderEffectsPanel(g, hand);
        }
    }

    public static void resetHand() {
        deck.addAll(hand);
        hand.clear();

        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(deck.remove((int) (Math.random() * deck.size())));
        }
        updateTotalCardWidth();
        initializeHand();
    }

    public static void updateTotalCardWidth() {
        totalCardWidth = Card.getCardWidth() * hand.size();
    }

    public static void gainEnergy(int energy) {
        totalEnergy += energy;
    }

    public static void initializeHand() {
        int zeroPos = Main.getScreenWidth() / 2;
        int firstCardX = zeroPos - totalCardWidth / 2;
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).initializePosition(firstCardX + i * Card.getCardWidth(), (int) (Main.getScreenHeight() - Card.getCardLength()));
        }
    }

    public void mousePressed(int button, int x, int y) {
        if (button == 0) {
            for (Card c : hand) {
                if (c.isOver(x, y)) {
                    c.drag(x, y);
                    selectionMode = true;
                }
            }
        }
    }
    public void mouseReleased(int button, int x, int y){
        if(button == 0) {
            for (Card c : hand) {
                if(c.isDragging()) {
                    entityManager.cardReleased(c, x, y);
                    c.reslot();
                    selectionMode = false;
                }
            }
        }
    }
    public void resetManager(){
        hand = new ArrayList<>();
        deck = new ArrayList<>();

        selectionMode = false;
        totalEnergy = 4;
        maximumEnergy = totalEnergy;

        deck.add(new BearBite());
        deck.add(new BearHug());
        deck.add(new BearsYearning());
        deck.add(new PlushPerfection());
        deck.add(new Sewing());
        deck.add(new NeedleToss());
        deck.add(new PrimalRage());

        resetHand();
    }
}
