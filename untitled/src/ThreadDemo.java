public class ThreadDemo implements Runnable{
    private int x = 0;
    private int y = 0;

    public static void main(String[] args) {
        ThreadDemo obj = new ThreadDemo();
        (new Thread(obj)).start();
        (new Thread(obj)).start();
    }
    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            x++;
            y++;
            System.out.println("x = "+x+" y = "+y);
        }
    }
}
