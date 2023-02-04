package Trump;

public class Run03 implements Runnable{
    @Override
    public void run() {
        if (Information.phase == 0) new Information().INIT();
    }
}