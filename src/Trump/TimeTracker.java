package Trump;


import java.util.Map;

public class TimeTracker {
    static boolean timeStop = false;
    static final int tickPerDay = 1;
    static final int dayInMonth = 10;
    static int counter = 0;
    static int apply = 0;
    TimeTracker(){
        while(true){
            if (Information.phase!=0&&!timeStop){
                apply();
                monthly();
                counter++;
                try{Thread.sleep(1000);
                }catch (Exception e){}
            } else {
                try{Thread.sleep(200);}
                catch (Exception e){}
            }
        }
    }
    void apply(){
        apply = counter/(tickPerDay*dayInMonth);
        counter = counter%(tickPerDay*dayInMonth);
    }
    void monthly(){
        for (;apply > 0; apply--){
            for (Map.Entry<String, Person> e: Information.personInfo.entrySet()){
                e.getValue().monthly();
            }
        }
    }
}

