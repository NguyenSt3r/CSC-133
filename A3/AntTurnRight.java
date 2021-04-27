package A3Prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AntTurnRight extends Command{
	GameWorld gw;
	
	public AntTurnRight(GameWorld gw) {
		super("AntTurnRight");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.turnRight();
	}
}
