package game.managers;

import core.Main;
import game.card.Attacking;
import game.card.Buffing;
import game.card.Card;
import game.card.bearCards.buff.*;
import game.card.bearCards.mutli.attack.ButtonBarrage;
import game.card.bearCards.mutli.attack.NeedleToss;
import game.card.bearCards.mutli.attack.ThreadTornado;
import game.card.bearCards.mutli.debuff.ButtonBomb;
import game.card.bearCards.single.attack.BearBite;
import game.card.bearCards.single.attack.BearHug;
import game.card.bearCards.single.attack.PawCrush;
import game.ui.Panel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import resources.Fonts;

import java.util.ArrayList;

public class CardManager {
    private static final int HAND_SIZE = 5;
    private static boolean selectionMode;
    private static int totalCardWidth;
    private static int totalEnergy;
    private static int curEnergy;

    private static ArrayList<Card> hand;
    private static ArrayList<Card> deck;

    private EntityManager entityManager;
    private static ArrayList<Card> addableCards;

    public CardManager(GameContainer gc) {
        Card.setGC(gc);
        Panel.setGC(gc);
        hand = new ArrayList<>();
        deck = new ArrayList<>();
        addableCards = new ArrayList<>();

        selectionMode = false;
        totalEnergy = 4;
        curEnergy = totalEnergy;

        deck.add(new BearBite());
        deck.add(new BearHug());
        deck.add(new BearsYearning());
        deck.add(new PlushPerfection());
        deck.add(new Sewing());
        deck.add(new NeedleToss());
        deck.add(new PrimalRage());



        addableCards.add(new ButtonBomb());
        addableCards.add(new ExtraStuffing());
        addableCards.add(new FallacyOfReturn());
        addableCards.add(new WarmEmbrace());
        addableCards.add(new ButtonBarrage());
        addableCards.add(new NeedleToss());
        addableCards.add(new ThreadTornado());



        resetHand();

    }

    public void setEntityManager(EntityManager e) {
        this.entityManager = e;
    }

    public static void update() {
        for (int i = hand.size() - 1; i >= 0; i--) {
            if (hand.get(i).isUsed()) {
                hand.get(i).unuse();
                deck.add(hand.remove(i));
            }
        }
        updateTotalCardWidth();
        initializeHand();
    }

    public static void addNewCard() {
        if(!addableCards.isEmpty()) {
            Card c = addableCards.get((int) (Math.random() * addableCards.size()));

            addableCards.remove(c);
            deck.add(c);
        }
    }

    public static void render(Graphics g) {
        for (Card c : hand) {
            if (!c.isDragging()) {
                c.render(g);

            }
        }
        for (Card c : hand) {
            if (c.isDragging()) {
                if (c instanceof Buffing) {
                    EntityManager.getPlayerHitBox().renderHitBox(g);
                } else if (c instanceof Attacking) {
                    for (HitBox h : EntityManager.getHitBoxes()) {
                        if (h.hasEntity()) {
                            h.renderHitBox(g);
                        }
                    }
                }
                c.render(g);
            }
        }
        for (Card c : hand) {
            c.renderEffectsPanel(g, hand);
        }
        Fonts.DOGICAPIXEL.drawStringCentered(g, curEnergy + " / " + totalEnergy, (float) Main.getScreenWidth() / 2, (float) Main.getScreenHeight() / 2);
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

    public static void spendEnergy(int energy) {
        curEnergy -= energy;
    }

    public static void gainEnergy(int energy) {
        curEnergy += energy;
    }
    public static void resetEnergy(){
        curEnergy = totalEnergy;
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

    public void mouseReleased(int button, int x, int y) {
        if (button == 0) {
            for (Card c : hand) {
                if (c.isDragging()) {
                    if (canUse(c)) {
                        entityManager.cardReleased(c, x, y);
                    }
                    c.reslot();
                    selectionMode = false;
                }
            }
        }
    }

    private boolean canUse(Card c) {
        return c.getEnergyCost() <= curEnergy;
    }

    public void resetManager() {
        hand = new ArrayList<>();
        deck = new ArrayList<>();

        selectionMode = false;
        totalEnergy = 4;
        curEnergy = totalEnergy;

        deck.add(new BearBite());
        deck.add(new BearHug());
        deck.add(new BearsYearning());
        deck.add(new PlushPerfection());
        deck.add(new Sewing());
        deck.add(new NeedleToss());
        deck.add(new PrimalRage());

        resetHand();
        resetEnergy();
    }
}
