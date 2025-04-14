package core;

import game.MessageManager;
import game.World;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;
import resources.Images;
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
		gc.setShowFPS(true);

		world = new World(gc);

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
		MessageManager.render(g);
	}
	
	public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException 
	{
		// This code happens when you enter a gameState.
	}

	public void leave(GameContainer gc, StateBasedGame sbg) 
	{
		world.resetWorld();
	}

	public void keyPressed(int key, char c)
	{
		// This code happens every time the user presses a key
		world.keyPressed(key, c);

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
