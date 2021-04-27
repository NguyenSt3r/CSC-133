package A3Prj;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class AntCollideFlag extends Command
{
    GameWorld gw;

    public AntCollideFlag(GameWorld gw)
    {
        super("AntHitFlag");
        this.gw = gw;
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        gw.collideWithFlag();
    }
}
