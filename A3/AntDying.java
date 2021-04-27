package A3Prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AntDying extends Command{
	GameWorld gw;
	
	public AntDying(GameWorld gw) {
		super("AntDieCommand");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		gw.dying();
	}
}
