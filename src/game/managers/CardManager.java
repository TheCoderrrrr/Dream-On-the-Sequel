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
import game.card.bearCards.mutli.debuff.ComfortCurse;
import game.card.bearCards.mutli.debuff.StuffedSorrow;
import game.card.bearCards.single.attack.*;
import game.card.bearCards.single.debuff.CuddleCrush;
import game.card.bearCards.single.debuff.CupidsArrow;
import game.card.bearCards.single.debuff.MuffledRoar;
import game.card.bearCards.single.debuff.StitchedSilence;
import game.ui.panels.Panel;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import resources.Fonts;

import java.util.ArrayList;

public class CardManager {
    private static GameContainer gc;
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
        CardManager.gc = gc;
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
        addableCards.add(new ThreadTornado());
        addableCards.add(new ButtonBomb());
        addableCards.add(new ComfortCurse());
        addableCards.add(new StuffedSorrow());
        addableCards.add(new ConcealedClaws());
        addableCards.add(new Maul());
        addableCards.add(new PawCrush());
        addableCards.add(new PawPummel());
        addableCards.add(new Slam());
        addableCards.add(new Smash());
        addableCards.add(new CuddleCrush());
        addableCards.add(new CupidsArrow());
        addableCards.add(new MuffledRoar());
        addableCards.add(new StitchedSilence());



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
        overCard();
        updateTotalCardWidth();
        initializeHand();
    }
    public static void overCard(){
        for (Card c : hand) {
            if (c.isOver(gc.getInput().getMouseX(), gc.getInput().getMouseY()) || c.isDragging()) {
                c.hoveredPos();
            } else {
                c.defaultPos();
            }
        }
    }

    public static Card addNewCard() {
        if(!addableCards.isEmpty()) {
            Card c = addableCards.get((int) (Math.random() * addableCards.size()));

            addableCards.remove(c);
            deck.add(c);

            return c;
        }

        return null;
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
        renderEnergy(g);
    }
    public static void renderEnergy(Graphics g){
        g.setColor(new Color(255, 255, 255, 255));
        float width = Main.getScreenWidth() * .05f;
        g.fillRoundRect((float) Main.getScreenWidth() * .16f, (float) Main.getScreenHeight() * .868f , (float) (width * 1.32), Fonts.DOGICAPIXEL.getHeight(g, curEnergy + " / " + totalEnergy, 100, (float) (width * 0.38)), 10);
        g.setColor(Color.black);
        Fonts.DOGICAPIXEL.drawString(g, curEnergy + " / " + totalEnergy, (float) Main.getScreenWidth() * .162f, (float) Main.getScreenHeight() * .88f , (float) (width * 0.365));
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
        totalCardWidth = 0;
        for(Card c : hand){
            totalCardWidth += c.getCardWidth();
        }
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
        int curCardPosX = 0;
        for (Card card : hand) {
            card.initializePosition(firstCardX + curCardPosX, (int) (Main.getScreenHeight() - card.getCardLength()));
            curCardPosX += card.getCardWidth();
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
