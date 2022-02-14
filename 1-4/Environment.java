import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class Environment extends JFrame {

    private Canvas canvas;
    public static final int WIDTH = 500;
    public static final int HEIGHT = 400;
    
    private Thread previousThread = null;

    public Environment() {
        
        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");

        ArrayList<Hole> holes = new ArrayList<Hole>();
        this.canvas = new Canvas(holes);

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);


        JButton buttonBall = new JButton("Add ball");
        JButton buttonHole = new JButton("Add Hole");
        JButton buttonWithPriority = new JButton("With/out priority");
        JButton buttonWithJoin = new JButton("With Join");
        JButton buttonExit = new JButton("Exit");


        buttonBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int x = new Random().nextInt(canvas.getWidth());
                int y = new Random().nextInt(canvas.getHeight());

                Ball ball = new Ball(canvas, Color.blue, x, y);
                canvas.addBall(ball);

                BallThread thread = new BallThread(ball);
                thread.start();
            }
        });

        buttonHole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = new Random().nextInt(canvas.getWidth());
                int y = new Random().nextInt(canvas.getHeight());

                Hole b = new Hole(x, y);
                canvas.addHole(b);
            }
        });

        buttonWithPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int x = 10;
                int y = 10;

                

                for (int i = 0; i < 500; i++) {
                    Ball ball = new Ball(canvas, Color.blue, x, y);
                    canvas.addBall(ball);
                    BallThread thread = new BallThread(ball);
                    thread.start();
                }

                Ball priorityBall = new Ball(canvas, Color.red, x, y);
                canvas.addBall(priorityBall);
                BallThread priorityThread = new BallThread(priorityBall);
                priorityThread.setPriority(10);
                priorityThread.start();

            }
        });

        buttonWithJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int x = new Random().nextInt(canvas.getWidth());
                int y = new Random().nextInt(canvas.getHeight());

                float r = new Random().nextFloat();
                float g = new Random().nextFloat();
                float b = new Random().nextFloat();

                Ball ball = new Ball(canvas, new Color(r, g, b), x, y);
                canvas.addBall(ball);
                BallThread thread = new BallThread(ball, previousThread);
                previousThread = thread;
                thread.start();
            }
        });

        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        buttonPanel.add(buttonBall);
        buttonPanel.add(buttonHole);
        buttonPanel.add(buttonWithPriority);
        buttonPanel.add(buttonWithJoin);
        buttonPanel.add(buttonExit);
        
        
        content.add(buttonPanel, BorderLayout.SOUTH);
    }

}