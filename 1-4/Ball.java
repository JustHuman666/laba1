import java.util.Random;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

class Ball {
   
    private Canvas canvas;
    private static final int XSIZE = 20;
    private static final int YSIZE = 20;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;

    private Color color = Color.blue;
    public boolean isInGame = true;

    public Ball(Canvas c) {
        this.canvas = c;
        if (Math.random() < 0.5) {
            x = new Random().nextInt(this.canvas.getWidth());
            y = 0;
        } else {
            x = 0;
            y = new Random().nextInt(this.canvas.getHeight());
        }
    }

    public Ball(Canvas c,Color color,int x,int y) {
        this.color = color;
        this.canvas = c;
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
    }

    public void move() {
        x += dx;
        y += dy;
        if (x < 0) {
            x = 0;
            dx = -dx;
        }
        if (x + XSIZE >= this.canvas.getWidth()) {
            x = this.canvas.getWidth() - XSIZE;
            dx = -dx;
        }
        if (y < 0) {
            y = 0;
            dy = -dy;
        }
        if (y + YSIZE >= this.canvas.getHeight()) {
            y = this.canvas.getHeight() - YSIZE;
            dy = -dy;
        }
        this.canvas.repaint();
    }


    public boolean ifBallInHole(){

        for (int i = 0; i < canvas.holes.size(); i++) {

            int posX = canvas.holes.get(i).x;
            int posY = canvas.holes.get(i).y;

            double distance = Math.pow(x-posX,2) + Math.pow(y-posY,2);
            if (distance <= XSIZE*YSIZE)
            {
                return true;
            }
        }
        return false;
    }
}