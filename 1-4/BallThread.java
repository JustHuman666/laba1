public class BallThread extends Thread {
    private Ball ball;
    

    private Thread previousThread = null;

    private boolean ballWithJoin = false;

    public BallThread(Ball ball) {
        this.ball = ball;
    }

    public BallThread(Ball ball, Thread thread) {
        
        previousThread = thread;
        this.ball = ball;
        ballWithJoin = true;
    }

    @Override
    public void run() {
        try {
            if (previousThread != null && ballWithJoin){

                previousThread.join();

            }

            for (int i = 1; i < 10000; i++) {

                if (ball.ifBallInHole()) {

                    ball.isInGame = false;
                    break;
                }

                ball.move();
                Thread.sleep(5);
            }
        } catch (InterruptedException ex) {

            System.out.println("Something went wrong");
        }
    }
}