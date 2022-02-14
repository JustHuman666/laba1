import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Canvas extends JPanel {
    public ArrayList<Ball> balls = new ArrayList<>();
    public ArrayList<Hole> holes = new ArrayList<>();

    public int ballsInHolesAmount = 0;
    public JLabel inHolesCounter = new JLabel();

    public Canvas(ArrayList<Hole> holes){
        this.holes = holes;
        add(inHolesCounter, BorderLayout.SOUTH);
        inHolesCounter.setText("In holes: " + ballsInHolesAmount);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        inHolesCounter.setText("Balls in holes: " + ballsInHolesAmount);

        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            if (ball!=null){
                ball.draw(g2);
            }
                
        }

        for (int i = 0; i < holes.size(); i++) {
            Hole hole = holes.get(i);
            hole.draw(g2);
        }

        for (int i = 0; i < balls.size(); i++){
            if (!balls.get(i).isInGame){

                ballsInHolesAmount++;
                balls.remove(i);
            }
        }

        repaint();
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    public void addHole(Hole hole) {
        this.holes.add(hole);
    }
}