package A3Prj;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.*;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;


/**
 * The game controller.
 * 
 * Manages the game world state, and interprets user input.
 */
public final class Game extends Form
{
	private AntAccelerate accelerateCmd;
	private AntBrake brakeCmd;
	private AntTurnLeft turnLeftCmd;
	private AntTurnRight turnRightCmd;
	private AntCollideFlag hitFlagCmd;
	private AntCollideFoodStation hitFoodCmd;
	private AntCollideSpider hitSpiderCmd;
	private ClockTick tickCmd;
	private ExitCmd exitCmd;
	private SoundCmd soundCmd;
	private InfoCmd aboutCmd;
	private HelpCmd	helpCmd;
	
	private ScoreView sv;
	private MapView mv;
	private GameWorld gw;
	
	public Game()
	{
		/**
		 * create instance of gameworld and its observer
		 */
		gw = new GameWorld();
		mv  = new MapView();
		sv = new ScoreView();
		
		gw.addObserver(sv);
		gw.addObserver(mv);
		gw.init();
		
		/**
		 * instantiate the commands for the bugz game
		 */
		accelerateCmd = new AntAccelerate(gw);
		brakeCmd = new AntBrake(gw);
		turnLeftCmd = new AntTurnLeft(gw);
		turnRightCmd = new AntTurnRight(gw);
		hitFlagCmd = new AntCollideFlag(gw);
		hitFoodCmd = new AntCollideFoodStation(gw);
		hitSpiderCmd = new AntCollideSpider(gw);
		tickCmd = new ClockTick(gw);
		soundCmd = new SoundCmd(gw);
		exitCmd = new ExitCmd();
		aboutCmd = new InfoCmd();
		helpCmd = new HelpCmd();
		

		/**
		 * set a layout for the GUI function
		 */
		setLayout(new BorderLayout());
		
		
		/**
		 * layout the left margin on the WEST of the screen
		 * button to accelerate
		 * button to turn left
		 */
		//===================left--Margin============================
		Container leftMargin = new Container();
		leftMargin.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		
		GameButton accelerateButton = new GameButton("Accelerate");
		accelerateButton.addActionListener(accelerateCmd);
		leftMargin.addComponent(accelerateButton);
		addKeyListener('a', accelerateCmd);
		
		GameButton leftButton = new GameButton("Left");
		leftButton.addActionListener(turnLeftCmd);
		leftMargin.addComponent(leftButton);
		addKeyListener('l', turnLeftCmd);
			
		addComponent(BorderLayout.WEST, leftMargin);
		leftMargin.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(0, 0, 0)));
		
		
		/**
		 * layout the right margin in the East of the screen
		 * button to Brake
		 * button to Turn Right
		 */
		//====================right--Margin==========================
		Container rightMargin = new Container();
		rightMargin.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		GameButton brakeButton = new GameButton("Brake");

		brakeButton.addActionListener(brakeCmd);
		rightMargin.addComponent(brakeButton);
		addKeyListener('b', brakeCmd);
			
			
		GameButton rightButton = new GameButton("Right");
		rightButton.addActionListener(turnRightCmd);
		rightMargin.addComponent(rightButton);
		addKeyListener('r', turnRightCmd);

			
		addComponent(BorderLayout.EAST, rightMargin);
		rightMargin.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(0, 0, 0)));
		
		
		/**
		 * layout the bottom margin to the south of the sreeen
		 * Button to Collide with the Spider
		 * Button to Collide with the Flag
		 * Button to Collide with the Food Stations
		 * Button to for clock ticking 
		 */
		//=====================bottom--Margin=========================
		Container bottomMargin = new Container();
		bottomMargin.setLayout(new FlowLayout(Component.CENTER));
			
		/*GameButton collideFlagButton = new GameButton("Collide with Flag");
		collideFlagButton.addActionListener(hitFlagCmd);
		bottomMargin.addComponent(collideFlagButton);

		GameButton collideSpiderButton = new GameButton("Collide with Spider");
		collideSpiderButton.addActionListener(hitSpiderCmd);
		bottomMargin.addComponent(collideSpiderButton);
		addKeyListener('g', hitSpiderCmd);
			
		GameButton collideFoodButton = new GameButton("Collide with Food");
		collideFoodButton.addActionListener(hitFoodCmd);
		bottomMargin.addComponent(collideFoodButton);
		addKeyListener('f', hitFoodCmd);
			
		GameButton tickButton = new GameButton("Tick");
		tickButton.addActionListener(tickCmd);
		bottomMargin.addComponent(tickButton);
		addKeyListener('t', tickCmd);*/

		GameButton position = new GameButton(" Position ");
		position.addActionListener(hitFoodCmd);
		addKeyListener('f', hitFoodCmd);
		bottomMargin.addComponent(position);


		GameButton pause = new GameButton(" Pause ");
		pause.addActionListener(tickCmd);
		bottomMargin.addComponent(pause);
		addKeyListener('t', tickCmd);


		addComponent(BorderLayout.SOUTH, bottomMargin);
		bottomMargin.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(211, 211, 211)));	
		
		/**
		 * create a side menu with four function on the top left corner of the screen
		 * Accelerate = to increase ant speed
		 * Quit = quit the game
		 * Sound = to turn the sound ON or OFF
		 * About = to introduce the develop
		 * Help = to tell what key command to use in the game.
		 */
		//===================================Side--Menu==========================================
		Toolbar sideMenu = new Toolbar();
		sideMenu.getStyle().setBgColor(ColorUtil.rgb(225,255,255));
		setToolbar(sideMenu);
		sideMenu.setTitle("The Path Game");

		//side menu for exit command
			
		
		//side menu for sound command
		CheckBox soundCheck = new CheckBox();
		soundCheck.setSelected(true);
		soundCheck.setCommand(soundCmd);
		soundCmd.putClientProperty("Side Component", soundCheck);
	
		sideMenu.addCommandToRightBar(helpCmd);
		
		//add command to side menu
		sideMenu.addCommandToSideMenu(accelerateCmd);
		sideMenu.addCommandToSideMenu(soundCmd);
		sideMenu.addCommandToSideMenu(aboutCmd);
		sideMenu.addCommandToSideMenu(exitCmd);
		
		/**
		 * set the scoreviews and mapview to a specific location on the screen
		 */
		//sv.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(255, 0, 0)));
		//mv.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(255, 0, 0)));

		addComponent(BorderLayout.NORTH, sv);
		addComponent(BorderLayout.CENTER, mv);
		
		
		/**
		 * set gameworld width and height from the mapview observer
		 * notify the observer
		 */
		gw.setHeight(mv.getHeight());
		gw.setWidth(mv.getWidth());
		gw.notifyObservers();
		show();
	}
}
