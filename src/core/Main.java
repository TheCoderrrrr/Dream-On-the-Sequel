package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame 
{
	public final static int FRAMES_PER_SECOND = 60;
	private static AppGameContainer appgc;
	
    public static final int GAME_ID  = 1;
	public static final int TITLE_ID = 0;
	public static final int TUTORIAL_ID = 2;
	public static final int LOSE_ID = 3;
	public static final int GETCARD_ID = 4;
	public static final int GETARTIFACT_ID = 5;


	private BasicGameState title;
	private BasicGameState game;
	private BasicGameState getCard;
	private BasicGameState tutorial;
	private BasicGameState lose;
	private BasicGameState getArtifact;

	public Main(String name) 
	{
		super(name);

		title = new TitleScreen(TITLE_ID);
		game = new Game(GAME_ID);
		getCard = new CardAcquire(GETCARD_ID);
		getArtifact = new ArtifactAcquire(GETARTIFACT_ID);
		tutorial = new Tutorial(TUTORIAL_ID);
		lose = new Lose(LOSE_ID);
	}

	public static int getScreenWidth()
	{
		return appgc.getScreenWidth();
	}
	
	public static int getScreenHeight()
	{
		return appgc.getScreenHeight();
	}
	

	public void initStatesList(GameContainer gc) throws SlickException
	{
		addState(title);
		addState(game);
		addState(getCard);
		addState(tutorial);
		addState(getArtifact);
		addState(lose);
	}

	public static void main(String[] args) 
	{
		try 
		{
			appgc = new AppGameContainer(new Main("My First Project"));
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		
			appgc.setDisplayMode(appgc.getScreenWidth(), appgc.getScreenHeight(), false);
			appgc.setTargetFrameRate(FRAMES_PER_SECOND);
			appgc.setVSync(true);
			appgc.start();

		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}

	}
}