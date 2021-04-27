package A3Prj;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;

public class AntCollideFoodStation extends Command{

    GameWorld gw;

    public AntCollideFoodStation(GameWorld gw)
    {
        super("AntHitFoodStation");
        this.gw = gw;

    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        gw.collidingWithFoodStation();
    }
}
