public class Main{
    public static void main(String[] args) {
        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                new TestFrame("Test");
            }
        });
        mainThread.start();


    }
}
