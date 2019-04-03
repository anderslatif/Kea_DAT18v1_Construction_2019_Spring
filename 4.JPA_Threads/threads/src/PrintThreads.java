public class PrintThreads extends Thread {
    private String sentence;
    private static Object lock = new Object();

    public static void main(String[] args) {
            PrintThreads thread1 = new PrintThreads("Jeg er nummer 1");
            PrintThreads thread2 = new PrintThreads("Hello there. Hello there.");
            PrintThreads thread3 = new PrintThreads("I've been expecting you mr. bond");
            PrintThreads thread4 = new PrintThreads("This is a test sentence");
            PrintThreads thread5 = new PrintThreads("11111111111111111111111111");
            PrintThreads thread6 = new PrintThreads("22222222222222222222222222");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }

    PrintThreads(String sentence) {
        this.sentence = sentence;
    }

    private void myPrintMethod(char c) {
        System.out.print(c);
    }

    public void run() {
        char c;

        synchronized (this) {
            for (int i = 0; i < sentence.length(); i++) {
                myPrintMethod(sentence.charAt(i));
            }
        }

    }
}
