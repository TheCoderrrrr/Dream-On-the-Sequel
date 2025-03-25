package game.managers;

import core.Main;
import game.World;
import game.card.Card;
import game.card.bearCards.buff.BearsYearning;
import game.card.bearCards.buff.PlushPerfection;
import game.card.bearCards.buff.Sewing;
import game.card.bearCards.single.attack.BearBite;
import game.card.bearCards.single.attack.BearHug;
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
        deck.add(new BearsYearning());
        deck.add(new PlushPerfection());
        deck.add(new Sewing());

        resetHand();

    }

    public void setEntityManager(EntityManager e) {
        this.entityManager = e;
    }

    public static void update() {
        for(int i=hand.size() - 1; i>=0; i--) {
            if(hand.get(i).isUsed()) {
                hand.remove(i);
            }
        }
        updateTotalCardWidth();
        initializeHand();
    }

    public static void render(Graphics g) {
        for (Card c : hand) {
            c.render(g);
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

    public static void initializeHand() {
        int zeroPos = Main.getScreenWidth() / 2;
        int firstCardX = zeroPos - totalCardWidth / 2;
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).initializePosition(firstCardX + i * Card.getCardWidth(), (int) (Main.getScreenHeight() - Card.getCardLength() * 0.6));
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
}
