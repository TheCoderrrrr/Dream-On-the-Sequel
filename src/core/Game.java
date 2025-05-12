package core;

import game.managers.MessageManager;
import game.World;
import game.messages.FloatMessage;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Sounds;

public class Game extends BasicGameState 
{	
	private int id;

	private World world;

	public Game(int id) 
	{
		this.id = id;
	}
	
	public int getID() 
	{
		return id;		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		gc.setShowFPS(false);

		world = new World(gc, sbg);
		CardAcquire.setWorld(world);
		ArtifactAcquire.setWorld(world);
		TitleScreen.setWorld(world);

		MessageManager.init();
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{	
		// This updates your game's logic every frame.  NO DRAWING.
		world.update();
		if(world.getGameStage().equals("end")){
			sbg.enterState(Main.LOSE_ID);
		}
		MessageManager.update();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		// This code renders shapes and images every frame.

		g.setColor(Color.white);
		world.render(g);
		world.renderRound(g);
		MessageManager.render(g);
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		MessageManager.addMessage(new FloatMessage("ROUND : " + world.getRound(), Main.getScreenWidth() / 2, Main.getScreenHeight() / 4, Color.black, 120));

		// This code happens when you enter a gameState.
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
//		world.resetWorld();
	}

	public void keyPressed(int key, char c)
	{
		// This code happens every time the user presses a key
		world.keyPressed(key, c);

		if(key == Input.KEY_P){
			world.killeverything();
		}
	}
	
	public void mousePressed(int button, int x, int y)
	{
		world.mousePressed(button,x , y);
	}
	public void mouseReleased(int button, int x, int y)
	{
		world.mouseReleased(button,x , y);
	}
	
	


}
