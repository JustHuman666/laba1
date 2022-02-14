import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Hole {
    
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    public int x = 0;
    public int y = 0;

    public Hole(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.black);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }
}