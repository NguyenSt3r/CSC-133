package A3Prj;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.plaf.Border;

import java.util.Observable;
import java.util.Observer;

import static com.codename1.ui.CN.convertToPixels;

public class MapView extends Container implements Observer{
	
	public MapView() {
	    this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.rgb(255, 0, 0)));

        //method for adding shapes...
        addShapes(400 , 100,ColorUtil.rgb(100,149,237));

	}


	public  void addShapes(int x1 , int y1, int color){


        int x = x1, y = y1, width= 30, height = 30;


        //for drawing shapes and string on the screen
        this.getUnselectedStyle().setBgPainter(new Painter() {
            @Override
            public void paint(Graphics g, Rectangle rect) {


                //for 1
                g.setColor(color);
                g.fillRect(x,y,width,height);
                //g.drawPolygon(xPoints,yPoints,nPoints);
                g.setColor(ColorUtil.rgb(225,225,255));
                g.drawString("1",x+10,y+6);

                //for 2

                g.setColor(color);
                g.fillRect(x+500,y-50,width,height);
                g.setColor(ColorUtil.rgb(225,225,255));
                g.drawString("2",x+510,y-40);


                //for 3

                g.setColor(color);
                g.fillRect(x+300,y+200,width,height);
                g.setColor(ColorUtil.rgb(225,225,255));
                g.drawString("3",x+310,y+210);


                //for 4

                g.setColor(color);
                g.fillRect(x+600,y+200,width,height);
                g.setColor(ColorUtil.rgb(225,225,255));
                g.drawString("4",x+610,y+210);

                //for red circle / rect
                int r = 25;
                g.setColor(ColorUtil.rgb(255,0,0));
                //g.fillRect(500,180,30,30);
                g.fillArc(500, 180, 2*r, 2*r, 0, 360);

                //draw empty rect - 1
                g.setColor(ColorUtil.rgb(0,0,0));
                g.drawRect(x+350,y+50,width,height);


                //draw empty rect - 2
                g.setColor(ColorUtil.rgb(0,0,0));
                g.drawRect(x-200,y+200,width+10,height+10);
                //repaint();


                //shape 15
                //ColorUtil.rgb(139,69,19)
                g.setColor(ColorUtil.rgb(34,139,34));
                g.fillRect(x-70,y-30,width,height);
                g.setColor(ColorUtil.rgb(225,225,255));
                g.drawString("15",x-60,y-20);



                //shape 20
                g.setColor(ColorUtil.rgb(34,139,34));
                g.fillRect(x+600,y+350,width,height);
                g.setColor(ColorUtil.rgb(225,225,255));
                g.drawString("20",x+610,y+356);



            }
        });
    }

    @Override
    public void pointerPressed(int x, int y) {
        super.pointerPressed(x, y);

        x = x - getParent().getAbsoluteX();
        y = y - getParent().getAbsoluteY();

    }

    @Override
    public void update(Observable o, Object data)
    {
        IGameWorld gw = (IGameWorld) data;
        gw.setDimension(this.getWidth(), this.getHeight());
        gw.printMap();

        repaint();
    }

}
