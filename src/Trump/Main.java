package Trump;

public class Main {
    //See the project without spending time testing it
    //Please visit
    //https://youtu.be/4fsEzZAxuZ4
    //
    //t3 = info processing, t4 = timetracker, t2 = console, t1 = frame
    public static void main(String[] arg) {
        Thread t1 = new Thread(new Run01());
        Thread t2 = new Thread(new Run02());
        Thread t3 = new Thread(new Run03());
        Thread t4 = new Thread(new Run04());
        t3.start();
        new Intro();
        t1.start();
        t2.start();
        t4.start();
    }
}