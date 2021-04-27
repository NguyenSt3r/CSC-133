package A3Prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AntAccelerate extends Command{
	GameWorld gw;
	
	public AntAccelerate(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.accelerate();
	}
}
